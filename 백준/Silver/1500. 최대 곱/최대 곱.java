import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S,K;
	static long tot = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int left = S % K;
		int n = S/K;
		for (int i = 0; i < K; i++) {
			if (left-- > 0) {
				tot *= n+1;
			} else {
				tot *= n;
			}
		}
		System.out.println(tot);
	}

}
