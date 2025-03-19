import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,T;
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
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adjlst = new ArrayList[N+1];
			nums = new int[N+1];
			que = new ArrayDeque<>();
			lst = new ArrayList<>();
			pre = new int[N+1];
			build = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				adjlst[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				build[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				if (nums[e] == 0) notzeros++;
				nums[e]++;
				adjlst[s].add(e);
			}
			st = new StringTokenizer(br.readLine());
			goal = Integer.parseInt(st.nextToken());
			
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
			System.out.println(pre[goal] + build[goal]);
		}
		
	}

}
