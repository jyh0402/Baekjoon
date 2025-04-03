import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] dice;
	static int botI,topI,num;
	static int[] max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dice = new int[N][6];
		max = new int[6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 6; i++) {
			botI = i;			
			max[i] += Max(0);
			for (int h = 1; h < N; h++) {
				for (int j = 0; j < 6; j++) {
					if (num == dice[h][j]) {
						botI = j;
						break;
					}					
				}
				max[i] += Max(h);			
			}
		}
		int Max = 0;
		for (int i = 0; i < 6; i++) {
			Max = Math.max(Max, max[i]);
		}
		System.out.println(Max);
	}
	private static int Max(int height) {
		if (botI == 0) topI = 5;
		else if (botI < 3) topI = botI + 2;
		else if (botI < 5) topI = botI - 2;
		else topI = 0;
		num = dice[height][topI];
		int m = 0;
		for (int i = 6; i > 3; i--) {
			if (i == dice[height][botI] || i == dice[height][topI]) continue;
			m = i;
			break;
		}
		return m;
	}

}
