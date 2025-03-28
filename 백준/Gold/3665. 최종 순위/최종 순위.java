import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int T,N,M;
	static int[] teams;
	static int[][] adj;
	static int[] indegree;
	static int zerocnt;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			zerocnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			teams = new int[N];
			adj = new int[N+1][N+1];
			indegree = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				teams[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					adj[teams[i]][teams[j]] = 1;
					if (indegree[teams[j]] == 0) {
						zerocnt++;
					}
					indegree[teams[j]]++;
				}
			}
			
			st = new StringTokenizer(br.readLine());			
			M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (adj[a][b] == 1) {
					adj[a][b] = 0;
					adj[b][a] = 1;
					indegree[b]--;
					indegree[a]++;					
				} else {
					adj[a][b] = 1;
					adj[b][a] = 0;
					indegree[b]++;
					indegree[a]--;	
				}
			}
			
			ArrayDeque<Integer> que = new ArrayDeque<>();
			ArrayList<Integer> lst = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					que.offer(i);
				}
			}
			while(!que.isEmpty()) {
				int cur = que.poll();
				lst.add(cur);
				for (int i = 1; i < N+1; i++) {
					if (adj[cur][i] == 1) {
						indegree[i]--;
						if (indegree[i] == 0) {
							que.offer(i);
							zerocnt--;
						}
					}
				}
			}
			if (zerocnt == 0) {
				for (int i = 0; i < lst.size(); i++) {
					sb.append(lst.get(i) + " ");
				}
				sb.append("\n");
			} else {
				sb.append("IMPOSSIBLE\n");
			}
		}
		
		System.out.println(sb);
	}

}
