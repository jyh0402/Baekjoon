import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int cnt;
	static int[] nums;
	static ArrayList<Integer> dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N];
		dp = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			if (dp.isEmpty() || nums[i] > dp.get(dp.size()-1)) {
				dp.add(nums[i]);
			} else {
				int idx = Collections.binarySearch(dp, nums[i]);
				if (idx < 0) {
					idx = -idx-1;
				}
				dp.set(idx, nums[i]);
			}
		}
		cnt = dp.size();
		System.out.println(cnt);		
	}
}