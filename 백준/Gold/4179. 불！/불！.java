import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static int sr,sc,fr,fc;
	static int min;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> move = new ArrayDeque<>();
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'J') {
					sr = i;
					sc = j;
				} else if (map[i][j] == 'F') {
					move.offer(new int[] {i,j,0,1});
				}
			}
		}
		
		move.offer(new int[] {sr,sc,0,2});
		visited[sr][sc] = true;
		
		while(!move.isEmpty()) {
			int[] cur = move.poll();
			if (cur[3] == 2) {
				if (cur[0] == 0 || cur[1] == 0 || cur[0] == R-1 || cur[1] == C-1) {
					min = cur[2]+1;
					System.out.println(min);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (map[nr][nc] == '.' && visited[nr][nc] == false) {
						move.offer(new int[] {nr,nc,cur[2]+1,2});
						visited[nr][nc] = true;
					}
				}
			} else if (cur[3] == 1){
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (!check(nr,nc)) continue;
					if (map[nr][nc] == '.' || map[nr][nc] == 'J') {
						map[nr][nc] = 'F';
						move.offer(new int[] {nr,nc,0,1});
					}
				}
			}
			
		}
		System.out.println("IMPOSSIBLE");
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}

}
