import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] mars;
	static int[][][] dp;
	static int[] dr = {1,0,0};
	static int[] dc = {0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mars = new int[N][M];
		dp = new int[N][M][3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], Integer.MIN_VALUE/2);
			}
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mars[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0][1] = mars[0][0];
		for (int i = 1; i < M; i++) {
			dp[0][i][1] = dp[0][i-1][1] + mars[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j][0] = Math.max(dp[i-1][j][0], Math.max(dp[i-1][j][1], dp[i-1][j][2])) + mars[i][j];
			}
			for (int j = 1; j < M; j++) {
				dp[i][j][1] = Math.max(dp[i][j-1][0], dp[i][j-1][1]) + mars[i][j];
			}
			for (int j = M-2; j >= 0; j--) {
				dp[i][j][2] = Math.max(dp[i][j+1][0], dp[i][j+1][2]) + mars[i][j];
			}
		}
		int max = Math.max(dp[N-1][M-1][0], Math.max(dp[N-1][M-1][1], dp[N-1][M-1][2]));
		System.out.println(max);
	}

}
