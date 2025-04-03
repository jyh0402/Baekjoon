import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1000000000;
	static int N;
	static long[][] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new long[N][10];
		for (int i = 1; i < 10; i++) {
			nums[0][i] = 1;
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j > 0) {
					nums[i][j] += nums[i-1][j-1];
				}
				if (j < 9) {
					nums[i][j] += nums[i-1][j+1];
				}
				nums[i][j] %= MOD;
			}
		}
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += nums[N-1][i];
		}
		ans %= MOD;
		System.out.println(ans);
	}
}