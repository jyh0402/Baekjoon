import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	static int[][] arr, copy;
	static boolean[][] visited;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		copy = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int n = Math.min(N, M)/2;
		for (int i = 0; i < n; i++) {
			spin(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(copy[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	private static void spin(int depth) {
		int tot = (N+M) * 2 - 4 - 8*depth;
		int r = R % tot;
		int sr = depth;
		int sc = depth;
		int d = 0;
		for (int i = 0; i < tot; i++) {
			int nr = sr + dr[d];
			int nc = sc + dc[d];
			if (!check(nr,nc) || visited[nr][nc]) {
				d = (d+1)%4;
				nr = sr + dr[d];
				nc = sc + dc[d];
			}
			move(sr,sc,d,r);
			sr = nr;
			sc = nc;
		}
		sr = depth;
		sc = depth;
		d = 0;
		for (int i = 0; i < tot; i++) {
			int nr = sr + dr[d];
			int nc = sc + dc[d];
			if (!check(nr,nc) || visited[nr][nc]) {
				if (nr == depth && nc == depth) {
					return;
				}
				d = (d+1)%4;
				nr = sr + dr[d];
				nc = sc + dc[d];
			}
			visited[sr][sc] = true;
			sr = nr;
			sc = nc;
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
	private static void move(int sr, int sc, int d, int r) {
		int num = arr[sr][sc];
		int nr = sr;
		int nc = sc;
		for (int i = 0; i < r; i++) {
			nr += dr[d];
			nc += dc[d];
			if (!check(nr,nc) || visited[nr][nc]) {
				nr -= dr[d];
				nc -= dc[d];
				d = (d+1)%4;
				nr += dr[d];
				nc += dc[d];						
			}
		}
		copy[nr][nc] = num;
	}

}
