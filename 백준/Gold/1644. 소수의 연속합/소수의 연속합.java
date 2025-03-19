import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] nums;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
        if (N == 1) {
			System.out.println(0);
			return;
		}
		nums = new boolean[N+1];
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (!nums[i]) {
				lst.add(i);
				for (int j = i * 2; j <= N; j+=i) {
					nums[j] = true;
				}
			}
		}
		int front = 0;
		int back = 0;
		while(back <= lst.size()) {
			int sum = 0;
			for (int i = back; i <= front; i++) {
				sum += lst.get(i);
			}
			if (sum == N) {
				cnt++;
				if (back == lst.size()-1) break;
				back++;
			}
			else if (sum < N) {
				if (front == lst.size()-1)
					break;
				front++;
			}
			else if (sum > N) back++;
		}
		System.out.println(cnt);
		
	}

}
