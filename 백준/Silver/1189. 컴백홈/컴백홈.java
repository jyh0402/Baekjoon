import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,K;
	static int cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch[j];
			}
		}
		visited[R-1][0] = true;
		dfs(R-1,0,1);
		System.out.println(cnt);
	}
	private static void dfs(int r, int c, int dis) {
		if (dis > K) return;
		if (dis == K) {
			if (r == 0 && c == C-1) {
				cnt++;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!check(nr,nc) || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr,nc,dis+1);
			visited[nr][nc] = false;
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.';
	}

}
