import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList[] adjlst;
	static ArrayDeque<Integer> que;
	static int[] nums;
	static int notzeros;
	static ArrayList<Integer> lst;
	static int[] pre;
	static int[] build;
	static int goal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		adjlst = new ArrayList[N+1];
		nums = new int[N+1];
		que = new ArrayDeque<>();
		lst = new ArrayList<>();
		pre = new int[N+1];
		build = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			adjlst[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			build[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int n = Integer.parseInt(st.nextToken());
				if (n == -1) break;
				if (nums[i] == 0) notzeros++;
				adjlst[n].add(i);
				nums[i]++;
			}
			
		}
		
		for (int i = 1; i <= N; i++) {
			if (nums[i] == 0) {
				que.offer(i);
			}
		}
		
		while(notzeros > 0) {
			int cur = que.poll();
			for (int i = 0; i < adjlst[cur].size(); i++) {
				int next = (int) adjlst[cur].get(i);
				nums[next]--;
				pre[next] = Math.max(pre[next], build[cur]+pre[cur]);
				if (nums[next] == 0) {
					notzeros--;
					que.offer(next);
				}
			}
			lst.add(cur);
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(pre[i] + build[i]);
		}
		
		
	}

}
