import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long A,B;
	static long cnt, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		StringBuilder sb = new StringBuilder();
		cnt = GCD(A,B);
		for (long i = 0; i < cnt; i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}
	private static long GCD(long a, long b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a%b);
	}

}
