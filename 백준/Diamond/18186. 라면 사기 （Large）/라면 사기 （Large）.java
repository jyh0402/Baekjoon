import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long B,C;
	static int[] ramen;
	static long cnt;
	static int buy;
	static long tot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		ramen = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ramen[i] = Integer.parseInt(st.nextToken());
			tot += ramen[i];
		}
		long[] cost = {B,B+C,B + 2 * C};
		if (B < C) {
			cnt = tot * B;
		} else {
			for (int i = 0; i < N; i++) {
				if (ramen[i]== 0) continue;
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
		}	

		System.out.println(cnt);
	}

}
