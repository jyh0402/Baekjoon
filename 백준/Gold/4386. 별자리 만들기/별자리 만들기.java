import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static double[][] stars;
	static double[][] map;
	static double sum;
	static class Edge implements Comparable<Edge>{
		int n;
		double w;
		public Edge(int n, double w) {
			this.n = n;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	static PriorityQueue<Edge> pq;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		stars = new double[N][2];
		map = new double[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = dis(i,j);
			}
		}
		
		visited = new boolean[N];
		pq = new PriorityQueue<>();
		prim();
		
		System.out.printf("%.2f",sum);
	}
	private static double dis(int i, int j) {
		double r1 = stars[i][0];
		double c1 = stars[i][1];
		double r2 = stars[j][0];
		double c2 = stars[j][1];
		return Math.sqrt(Math.pow(r1-r2,2) + Math.pow(c1-c2,2));
	}
	private static void prim() {
		visited[0] = true;
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			pq.offer(new Edge(i,map[0][i]));

		}
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.n]) continue;
			visited[cur.n] = true;
			sum += cur.w;
			for (int j = 0; j < N; j++) {
				if (visited[j]) continue;
				pq.offer(new Edge(j,map[cur.n][j]));
			}
		}
	}
}
