import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] nums;
	static int x;
	static int cnt;
	static int front,back;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		front = 0;
		back = n-1;
		while(front<back) {
			int sum = nums[front] + nums[back];
			if (sum > x) {
				back--;
			} else if (sum < x){
				front++;
			} else if (sum == x){
				cnt++;
				back--;
				front++;
			}
			
		}
		System.out.println(cnt);
	}

}
