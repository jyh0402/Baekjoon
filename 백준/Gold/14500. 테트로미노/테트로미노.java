import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int max;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static boolean[][] visited;
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
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,0,0);
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int d = 0; d < 4; d++) {
					int tot = map[i][j];
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (!check(nr,nc)) continue;
					tot += map[nr][nc];
					
					int nd = (d+1) % 4;
					int nnr = nr + dr[nd];
					int nnc = nc + dc[nd];
					if (!check(nnr,nnc)) continue;
					tot += map[nnr][nnc];
					
					nd = (d+3) % 4;
					nnr = nr + dr[nd];
					nnc = nc + dc[nd];
					if (!check(nnr,nnc)) continue;
					tot += map[nnr][nnc];
					
					max = Math.max(max, tot);
				}
			}
		}
		System.out.println(max);
	}
	private static void dfs(int r, int c, int depth, int tot) {
		if (depth == 4) {
			max = Math.max(max, tot);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr,nc) || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr,nc,depth+1,tot+map[r][c]);
			visited[nr][nc] = false;
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
