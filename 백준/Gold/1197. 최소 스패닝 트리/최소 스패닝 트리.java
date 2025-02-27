import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V,E;
	static int A,B,C;
	static int min;
	static class Edge implements Comparable<Edge> {
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
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>();
		min = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			points.offer(new Edge(A, B, C));
		}
		makeSet();
		int cnt = 0;
		min = 0;
		while(cnt != V-1) {
			Edge edge = points.poll();
			if (union(edge.s, edge.e)) {
				cnt++;
				min += edge.w;
			}
		}
		System.out.println(min);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x==y) return false;
		if (r[x] < r[y]) {
			r[y] += r[x]; //더해주고
			p[x] = y;	//조상 교체
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
		p = new int[V+1];
		r = new int[V+1];
		for (int i = 0; i < V+1; i++) {
			p[i] = i; //부모가 누구냐
			r[i] = 1; //내가 몇째손이냐
		}
	}

}
