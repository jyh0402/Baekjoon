import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,tot,ans;
	static int[] choo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		choo = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			choo[i] = Integer.parseInt(st.nextToken());
			tot += choo[i];
		}
		Arrays.sort(choo);
		if (choo[0] > 1) {
			System.out.println(1);
			return;
		}
		int sum = choo[0];
		for (int i = 1; i < N; i++) {
			if (sum+1 < choo[i]) {
				ans = sum + 1;
				break;
			}
			sum += choo[i];
			if (i == N-1) {
				ans = sum+1;
			}
		}
		System.out.println(ans);
	}

}
