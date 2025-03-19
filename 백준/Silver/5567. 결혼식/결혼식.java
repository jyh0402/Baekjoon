import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int cnt;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		visited[1] = true;
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {1,0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < adj[cur[0]].size(); i++) {
				if (visited[adj[cur[0]].get(i)] || cur[1] == 2) continue;
				cnt++;
				visited[adj[cur[0]].get(i)] = true;	
				que.offer(new int[] {adj[cur[0]].get(i),cur[1]+1});
			}
		}
		System.out.println(cnt);
	}

}
