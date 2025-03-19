import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE/10;
	static int N,M;
	static ArrayList[] adj;
	static int[] path;
	static int[] dis;
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static PriorityQueue<Edge> pq;
	static int start,end;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		path = new int[N+1];
		dis = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dis, INF);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(s, e, w));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		pq.offer(new Edge(start,start,0));
		dis[start] = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.e]) continue;
			if (cur.e == end) break;
			visited[cur.e] = true;
			for (int i = 0; i < adj[cur.e].size(); i++) {
				Edge next = (Edge) adj[cur.e].get(i);
				int newdis = dis[cur.e] + next.w;
				if (dis[next.e] > newdis) {
					dis[next.e] = newdis;
					path[next.e] = next.s; 
					pq.offer(new Edge(next.s,next.e,newdis));
				}
			}
		}
		int cnt = 1;
		ArrayList<Integer> lst = new ArrayList<>();
		lst.add(end);
		int next = path[end];
		while(true) {			
			lst.add(next);
			cnt++;
			if (next == start)
				break;			
			next = path[next];	
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dis[end] + " \n");
		sb.append(cnt + "\n");
		for (int i = 0; i < lst.size(); i++) {
			sb.append(lst.get(lst.size()-i-1) + " ");
		}
		System.out.println(sb);
	}

}
