import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static BigInteger ans;
	static BigInteger[] hanoi;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		hanoi = new BigInteger[100];
		hanoi[0] = BigInteger.ONE;
		for (int i = 1; i < N; i++) {
            hanoi[i] = hanoi[i - 1].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
        }
		ans = hanoi[N-1];
		
		sb = new StringBuilder();
		if (N<=20) {
			System.out.println(ans);
			Hanoi(N,1,2,3);
			System.out.println(sb);
		} else System.out.print(ans);
		
	}
	private static void Hanoi(int n, int start, int mid, int end) {
		if (n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
		} else {
			Hanoi(n-1, start, end , mid);
			sb.append(start).append(" ").append(end).append("\n");
			Hanoi(n-1, mid, start, end);
		}
		
	}

}