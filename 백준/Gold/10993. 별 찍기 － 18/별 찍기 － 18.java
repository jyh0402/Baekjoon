import java.util.Scanner;

public class Main {
	
	static int board[][];
	static int N;
	static int R,C;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		R = (1<<N)-1;
		C = 2*R-1;
		board = new int[R][C];
		StringBuilder sb = new StringBuilder();
		star(0,R,N);
		if (N%2 == 0) {
			for(int i = 0; i <R ; i++) {
				for (int j = 0; j < C - i; j++) {
					if (board[i][j] == 1) {
						sb.append("*");
					}
					else
					{
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
		} else {
			for(int i = 0; i <R ; i++) {
				for (int j = 0; j <= C/2 + i; j++) {
					if (board[i][j] == 1) {
						sb.append("*");
					}
					else
					{
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
	}
	private static void star(int sr, int er, int n) {
		int height = (1 << n) - 1;
		if (n == 1) {
			board[sr][C/2] = 1;
			return;
		} else if (n % 2 == 0) { //역삼각형
			for (int i = C/2 - height + 1; i < C/2 + height; i++) {
				board[sr][i] = 1;
			}
			for (int i = 1; i < height; i++) {
				board[sr+i][C/2 - height + i + 1] = 1;
				board[sr+i][C/2 + height - i - 1] = 1;
			}
			star(sr+1,sr + height/2 + 1,n-1);
		} else { //삼각형
			for (int i = 0; i < height - 1; i++) {
				board[sr+i][C/2-i] = 1;
				board[sr+i][C/2+i] = 1;
			}
			for (int i = C/2 - height + 1; i < C/2 + height; i++) {
				board[er-1][i] = 1;
			}
			star(er - height/2 - 1,er-1,n-1);
		}
		return;
	}

}
