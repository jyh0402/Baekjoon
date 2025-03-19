import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int cnt;
	static int[][] visit;
	static int[] dr = {0,1,1};
	static int[] dc = {1,1,0};
	static ArrayDeque<int[]> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		que = new ArrayDeque<>();
		que.offer(new int[] {0,1,0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[2] == 0) {
				for (int d = 0; d < 2; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr,nc) || map[nr][nc] == 1) continue;
					if (d == 1 && (map[nr-1][nc] != 0 || map[nr][nc-1] != 0)) continue;
					visit[nr][nc]++;
					que.offer(new int[] {nr,nc,d});
				}
			} else if (cur[2] == 1) {
				for (int d = 0; d < 3; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr,nc) || map[nr][nc] == 1) continue;
					if (d == 1 && (map[nr-1][nc] != 0 || map[nr][nc-1] != 0)) continue;
					visit[nr][nc]++;
					que.offer(new int[] {nr,nc,d});
				}
			} else if (cur[2] == 2) {
				for (int d = 1; d <= 2; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr,nc) || map[nr][nc] == 1) continue;
					if (d == 1 && (map[nr-1][nc] != 0 || map[nr][nc-1] != 0)) continue;
					visit[nr][nc]++;
					que.offer(new int[] {nr,nc,d});
				}
			}
		}
		
		
		System.out.println(visit[N-1][N-1]);
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

}
