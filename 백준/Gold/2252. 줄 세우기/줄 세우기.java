import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static ArrayList[] adjlst;
	static ArrayDeque<Integer> que;
	static int[] nums;
	static int notzeros;
	static ArrayList<Integer> lst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjlst = new ArrayList[N+1];
		nums = new int[N+1];
		que = new ArrayDeque<>();
		lst = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			adjlst[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if (nums[e] == 0) notzeros++;
			nums[e]++;
			adjlst[s].add(e);
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
				if (nums[next] == 0) {
					notzeros--;
					que.offer(next);
				}
			}
			lst.add(cur);
		}
		
		while(!que.isEmpty()) {
			lst.add(que.poll());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(lst.get(i) + " ");
		}
		System.out.println(sb);
	}

}
