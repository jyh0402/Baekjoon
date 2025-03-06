import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static long K;
	static int[] S;
	static int min;
	static boolean[] Edgecheck;
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

		@Override
		public int hashCode() {
			return Objects.hash(e, s, w);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			return e == other.e && s == other.s && w == other.w;
		}
		
	}
	static int[] p;
	static int[] r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if (M <= 1) {
			System.out.println("YES");
			return;
		}
		K = Long.parseLong(st.nextToken());
		S = new int[N];
		st = new StringTokenizer(br.readLine());
		min = 10000000;
		Edgecheck = new boolean[N+1];
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, S[i]);
		}
		if (min > K) {
			System.out.println("NO");
			return;
		}
		for (int i = 1; i < N+1; i++) {
			Edgecheck[i] = true;	
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if ((!(s == N && e == 1) && s > e) || (s==1 && e == N)) {
			    int temp = s;
			    s = e;
			    e = temp;
			}
			Edgecheck[s] = false;
		}
		makeSet();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
		    int next = (i == N ? 1 : i + 1);
		    if (Edgecheck[i]) {  // 연결되어 있다면
		        if (union(i, next)) {
		            cnt++;
		        }
		    }
		}
		boolean[] visited = new boolean[N + 1];
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			int root = find(i);
			if (!visited[root]) {
				sum += S[root-1];
				visited[root] = true;
			}
		}
		if (sum > K) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x==y) return false;
		if (r[x] < r[y]) {
			r[y] += r[x]; //더해주고
			p[x] = y;	//조상 교체
			S[y-1] = Math.min(S[x-1], S[y-1]);
		} else {
			r[x] += r[y];
			p[y] = x;
			S[x-1] = Math.min(S[x-1], S[y-1]);
		}
		return true;
	}
	private static int find(int x) {
		if (x==p[x]) return p[x];
		else return p[x] = find(p[x]);
	}
	private static void makeSet() {
		p = new int[N+1];
		r = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			p[i] = i; //부모가 누구냐
			r[i] = 1; //내가 몇째손이냐
		}
	}
}
