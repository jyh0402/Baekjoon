import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE/2;
	static int N,E;
	static int[] visit;
	static class Edge implements Comparable<Edge>{
		int e;
		int w;
		public Edge(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static ArrayList<Edge>[] adj;
	static int[] dis;
	static PriorityQueue<Edge> pq;
	static int tot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}
		visit = new int[2];
		st = new StringTokenizer(br.readLine());
		visit[0] = Integer.parseInt(st.nextToken());
		visit[1] = Integer.parseInt(st.nextToken());
		int ans = INF;
		for (int i = 0; i < 2; i++) {
			tot = 0;
			int start = visit[i % 2];
			int end = visit[(i+1) % 2];
			dijstra(1,start);
			dijstra(start,end);
			dijstra(end,N);
			ans = Math.min(tot, ans);
		}
		
		if (ans >= INF || ans < 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	private static void dijstra(int start, int end) {
		dis = new int[N+1];
		Arrays.fill(dis, INF);
		pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		dis[start] = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.w > dis[cur.e]) continue;
			for (int i = 0; i < adj[cur.e].size(); i++) {
				Edge next = adj[cur.e].get(i);				
				int ndis = dis[cur.e] + next.w;
				if (dis[next.e] > ndis) {
					dis[next.e] = ndis;
					pq.offer(new Edge(next.e,ndis));
				}
				
			}
		}
		tot += dis[end];
		
	}

}
