
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] scv;
	static int min;
	static int[][] arr;
	static int[] nums;
	static int[] damage = {9,3,1};
	static boolean[][][] visited = new boolean[61][61][61];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		scv = new int[3];
		min = 1000;
		st = new StringTokenizer(br.readLine());
		nums = new int[3];
		for (int i = 0; i < 3; i++) {
			nums[i] = i;
		}
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		arr = new int[6][3];
		int cnt = 0;
		do {
			for (int i = 0; i < nums.length; i++) {
				arr[cnt][i] = nums[i];
			}
			cnt++;
		}while(np(2));
		bfs();
		System.out.println(min);
	}
	private static void bfs() {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(scv);
		que.offer(new int[] {1});
		while(!que.isEmpty()) {
			int[] scvd = que.poll();
			int cnt = que.poll()[0];
			for (int i = 0; i < 6; i++) {
				int[] nscv = new int[3];
				int deathcount = 0;				
				for (int j = 0; j < scvd.length; j++) {
					nscv[j] = scvd[j] - damage[arr[i][j]];
					if (nscv[j] <= 0) {
						nscv[j] = 0;
						deathcount++;
					}
				}
				if (visited[nscv[0]][nscv[1]][nscv[2]]) continue;
				else visited[nscv[0]][nscv[1]][nscv[2]] = true;
				if (deathcount == 3) {
					min = cnt;
					return;
				}
				
				que.offer(nscv);
				que.offer(new int[] {cnt+1});
			}
		}
		
	}
	private static boolean np(int size) {
		int i = size;
		while(i>0 && nums[i-1] > nums[i]) i--;
		if (i == 0) return false;
		int j = size;
		while(nums[i-1] > nums[j]) j--;
		int temp = nums[j];
		nums[j] = nums[i-1];
		nums[i-1] = temp;
		int k = size;
		while(i<k) {
			temp = nums[k];
			nums[k] = nums[i];
			nums[i] = temp;
			k--;
			i++;
		}
		return true;
	}

}
