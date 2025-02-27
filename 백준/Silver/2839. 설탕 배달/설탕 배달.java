import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int tot;
	static int remain;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		if (N == 4 || N == 7) {
			System.out.println(-1);
			return;
		}
		tot = N / 5;
		remain = N % 5;
		if (remain == 1 || remain == 3) {
			tot++;
		} else if (remain == 2 || remain == 4) {
			tot += 2;
		}
		System.out.println(tot);
	}

}
