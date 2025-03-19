import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int min;
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
	static int[] p;
	static int[] r;
	static PriorityQueue<Edge> pq;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(s,e,w));
		}
		makeSet();
		int cnt = 0;
		while(cnt != N-1) {
			Edge edge = pq.poll();
			if (union(edge.s,edge.e)) {
				cnt++;
				min += edge.w;
				max = Math.max(max, edge.w);
			}
		}
		System.out.println(min-max);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x==y) return false;
		if (r[x] < r[y]) {
			r[y]+=r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}
	private static int find(int x) {
		if (x == p[x]) return p[x];
		else return p[x] = find(p[x]);
	}
	private static void makeSet() {
		p = new int[N+1];
		r = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

}
