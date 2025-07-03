import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H,W,X,Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		int R = H+X;
		int C = W+Y;
		int[][] arr = new int[R][C];
		int[][] A = new int[H][W];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 0) continue;
				if (i < X || j < Y)
					A[i][j] = arr[i][j];
				else if (i >= H || j >= W) {
					if(A[i-X][j-Y] != 0) continue;
					A[i-X][j-Y] = arr[i][j];
				} else {
					if(A[i][j] != 0) continue;
					A[i][j] = arr[i][j] - A[i-X][j-Y]; 
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
