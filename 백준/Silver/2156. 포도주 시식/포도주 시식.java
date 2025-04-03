import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] wine;
	static int[][] drink;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		wine = new int[N];
		drink = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wine[i] = Integer.parseInt(st.nextToken());
		}
		drink[0][1] = wine[0];
		for (int i = 1; i < N; i++) {
			drink[i][0] = Math.max(drink[i-1][0], Math.max(drink[i-1][1], drink[i-1][2]));
			drink[i][1] = drink[i-1][0] + wine[i];
			drink[i][2] = drink[i-1][1] + wine[i];
		}
		int max = drink[N-1][0];
		for (int i = 1; i < 3; i++) {
			max = Math.max(max, drink[N-1][i]);
		}
		System.out.println(max);
	}

}
