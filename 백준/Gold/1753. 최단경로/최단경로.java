import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE/10;
	static int V,E,K;
	static class Edge implements Comparable<Edge> {
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static ArrayList[] adj;
	static int[] dis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		dis = new int[V+1];
		Arrays.fill(dis, INF);
		dis[K] = 0;
		adj = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e,w));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(K,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int i = 0; i < adj[cur.v].size(); i++) {
				Edge next = (Edge) adj[cur.v].get(i);
				int newdis = dis[cur.v] + next.w;
				if (dis[next.v] > newdis) {
					dis[next.v] = newdis;
					pq.add(new Edge(next.v,newdis));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dis[i] == INF) {
				sb.append("INF" + "\n");
			} else {
				sb.append(dis[i] + "\n");
			}			
		}
		System.out.println(sb);
	}

}
