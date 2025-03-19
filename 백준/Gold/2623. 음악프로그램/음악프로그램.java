import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static ArrayList<Integer>[] adj;
	static int[] indegree;
	static int Nzero;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		indegree = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 1) continue;
			int s = Integer.parseInt(st.nextToken());
			for (int j = 1; j < n; j++) {
				int e = Integer.parseInt(st.nextToken());
				adj[s].add(e);
				if (indegree[e] == 0) {					
					Nzero++;
				}
				indegree[e]++;
				s = e;
			}
		}
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				que.offer(i);
				cnt++;
			}
		}
		while(!que.isEmpty()) {
			int cur = que.poll();
			sb.append(cur + "\n");
			for (int i = 0; i < adj[cur].size(); i++) {				
				indegree[adj[cur].get(i)]--;
				if (indegree[adj[cur].get(i)] == 0) {
					que.offer(adj[cur].get(i));
					cnt++;
				}
			}
		}
		if (cnt !=  N) {
			System.out.println(0);
			return;
		}
		System.out.println(sb);
	}

}
