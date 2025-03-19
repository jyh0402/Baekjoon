import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static long an1,an2,an3;
	static long p = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int A = N-K;
		an1 = 1;
		an2 = 1;
		an3 = 1;
		for (int i = N; i > 0; i--) {
			an1 *= i;
			an1 %= p;
		}
		
		for (int i = A; i > 0; i--) {
			an2 *= i;
			an2 %= p;
		}
		for (int i = K; i > 0; i--) {
			an3 *= i;
			an3 %= p;
		}
		
		an2 = (an2 * an3) % p;
		
		long ans = (an1 * cal(an2,p-2)) % p;
		System.out.println(ans);
	}
	private static long cal(long x, long l) {
        if (l == 0) return 1;
		long result;
		if (l == 1) return x;
		else if (l % 2 == 0) {
			result = cal(x,l/2) % p;
			return (result * result) % p;
		} else {
			result = cal(x,l/2) % p;
			result = (result * result) % p;
			return (result *x) % p;
		}
	}

}
