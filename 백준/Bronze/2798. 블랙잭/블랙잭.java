import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int R;
	static int max;
	static int[] nums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = 3;
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		combi(0,0,0);
		System.out.println(max);
	}
	private static void combi(int depth, int start,int sum) {
        if (max == M) return;
		if (sum > M) return;
		if (depth == R) {
			max = Math.max(max,sum);
			return;
		}
		for (int i = start+1; i < N; i++) {
			combi(depth+1,i,sum+nums[i]);
		}
		
	}

}
