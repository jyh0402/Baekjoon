import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int min;
	static int cnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static HashSet<P>[] adj;
	static boolean[] visited;
	static PriorityQueue<P> points;
	static class P implements Comparable<P>{
		int v;
		int w;
		public P(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(P o) {
			return Integer.compare(this.w, o.w);
		}
		@Override
		public String toString() {
			return "P [v=" + v + ", w=" + w + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(v, w);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			P other = (P) obj;
			return v == other.v && w == other.w;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 1;
		//섬 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					FF(i,j);
					cnt++;
				}
			}
		}
		
		adj = new HashSet[cnt];
		for (int i = 0; i < cnt; i++) {
			adj[i] = new HashSet<P>();
		}
		//다리 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					bridge(i,j);
				}
			}
		}
		//프림
		min = prim();
		
		System.out.println(min);
	}
	private static int prim() {
		visited = new boolean[cnt];
		int min = 0;
		points = new PriorityQueue<>();
		points.offer(new P(1,0));
		int count = 0;
		while(!points.isEmpty()) {
			P cur = points.poll();
			if (visited[cur.v]) continue;
			min += cur.w;
			visited[cur.v] = true;
			if (cnt-1 == ++count) return min;
			for (P next : adj[cur.v]) {
				if (visited[next.v]) continue;
				points.offer(next);
			}
		}
		return -1;
	}
	private static void bridge(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int len = 0;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr,nc) || map[nr][nc] != 0) continue;
			while(check(nr,nc)) {
				if (map[nr][nc] != 0) {
					if (map[nr][nc] != map[r][c]) {
						if (len >= 2) {
							adj[map[r][c]-1].add(new P(map[nr][nc]-1,len));
						}
					}
					break;
				}
				nr += dr[d];
				nc += dc[d];
				len++;
			}
			
		}
		
	}
	private static void FF(int r, int c) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {r,c});
		map[r][c] +=cnt;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || map[nr][nc] != 1) continue;
				que.offer(new int[] {nr,nc});
				map[nr][nc] += cnt;
			}
		}
	}
	
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
