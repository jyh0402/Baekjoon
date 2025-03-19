import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] ramen;
	static long cnt;
	static int buy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ramen = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ramen[i] = Integer.parseInt(st.nextToken());
		}
		long[] cost = {3,5,7};
		for (int i = 0; i < N; i++) {
			
			if (i < N - 1) {
				if (ramen[i] > ramen[i+1]) {
					cnt += cost[0] * (ramen[i] - ramen[i+1]);
					ramen[i] = ramen[i+1];
				}				
				if (i < N-2) {
					if (ramen[i+1] > ramen[i+2]) {
						buy = Math.min(ramen[i], ramen[i+1] - ramen[i+2]);
						cnt += cost[1] * buy;
						ramen[i] -= buy;
						ramen[i+1] -= buy;
						if (ramen[i] == 0) continue;
					}
					cnt += cost[2] * ramen[i];
					ramen[i+2] -= ramen[i];
					ramen[i+1] -= ramen[i];
					ramen[i] = 0;
				} else {
					cnt += cost[1] * ramen[i];
					ramen[i+1] -= ramen[i];
					ramen[i] = 0;
				}
			} else {
				cnt += cost[0] * ramen[i];
				ramen[i] = 0 ;
			}
		}

		System.out.println(cnt);
	}

}
