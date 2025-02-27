import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] dist;
	static int[][] dp;
	static int min;
	static int INF = Integer.MAX_VALUE/100;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[1<<N][N];
		for (int i =0; i < 1<<N ; i++) {
            Arrays.fill(dp[i], -1);
        }
		min = tsp(1,0);
		System.out.println(min);
	}
	private static int tsp(int visited, int city) {
		if (visited == ((1<<N) - 1)) {
			if (dist[city][0] == 0) {
				return INF;
			}
			return dist[city][0];
		}
		if (dp[visited][city] != -1) {
			return dp[visited][city];
		}
		dp[visited][city] = INF;
		for (int i = 0; i < N; i++) {
			if ((visited & (1<<i)) != 0) continue;
			if (dist[city][i] == 0) continue;
			int res = tsp (visited | (1<<i),i) + dist[city][i];
			dp[visited][city] = Math.min(res, dp[visited][city]); 
		}
		return dp[visited][city];
	}

}
