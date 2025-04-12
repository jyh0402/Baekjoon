import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] cat;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cat = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cat[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cat);
		int F = 0,B = N-1;
		while(F<B) {
			if (cat[F] + cat[B] <= K) {
				cnt++;
				F++;
				B--;
			} else {
				B--;
			}
		}
		System.out.println(cnt);
	}

}
