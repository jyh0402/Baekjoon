import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i++) {
			int n = Integer.parseInt(st.nextToken());
			N += n;
			N *= 10;
		}
		N/= 10;
		if (N == 12345678) {
			System.out.println("ascending");
		} else if (N == 87654321) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
