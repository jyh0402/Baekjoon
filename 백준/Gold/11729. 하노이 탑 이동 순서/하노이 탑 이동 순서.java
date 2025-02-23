import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int ans;
	static int[] hanoi;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		hanoi = new int[20];
		hanoi[0] = 1;
		for (int i = 1; i < N; i++) {
			hanoi[i] = hanoi[i-1] * 2 + 1;
		}
		ans = hanoi[N-1];
		System.out.println(ans);
		sb = new StringBuilder();
		Hanoi(N,1,2,3);
		System.out.println(sb);		
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
