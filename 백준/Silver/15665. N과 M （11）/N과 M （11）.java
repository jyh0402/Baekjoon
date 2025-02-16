import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] p;
	static int[] nums;
	static StringBuilder answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N];
		
		answer = new StringBuilder();
		nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		perm(0);
		System.out.println(answer);
	}
	private static void perm(int depth) {
		int prv = 0;
		if (depth == M) {
			for (int i = 0; i < nums.length; i++) {
				answer.append(nums[i]).append(" ");
			}
			answer.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (prv == p[i]) continue;
			nums[depth] = p[i];
			perm(depth+1);
			nums[depth] = 0;
			prv = p[i];
		}
		
	}

}
