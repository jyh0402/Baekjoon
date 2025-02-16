import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int[] nums;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0,0,0);
		System.out.println(count);
	}
	private static void subset(int n, int tot, int cnt) {
		if (n == N) {
			if (tot == S && cnt != 0) {
				count++;
			}
			return;
		}
		subset(n+1,tot + nums[n], cnt+1);
		subset(n+1,tot, cnt);
		
	}

}
