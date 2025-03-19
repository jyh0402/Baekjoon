import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int s,e,w;
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
	static PriorityQueue<Edge> points;
	static int[] p;
	static int[] r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>();
		min = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, w));
		}
		makeSet();
		int cnt = 0;
		while(cnt != N-1) {
			Edge edge = points.poll();
			if (union(edge.s,edge.e)) {
				cnt++;
				min += edge.w;
			}
		}
		System.out.println(min);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return false;
		if (r[x] < r[y]) {
			r[y] += r[x];
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
		p = new int[N + 1];
		r = new int[N + 1];
		for (int i = 0; i < N+1; i++) {
			p[i] = i; //부모가 누구냐
			r[i] = 1; //내가 몇째손이냐
		}
	}
	

}
