import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] forest;
	static int time;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static ArrayDeque<int[]> que;
	static int sr,sc,er,ec;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		que = new ArrayDeque<>();
		forest = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			forest[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (forest[i][j] == '*') {
					que.offer(new int[] {i,j,0,0});
				} else if (forest[i][j] == 'S') {
					sr = i;
					sc = j;					
				} else if (forest[i][j] == 'D') {
					er = i;
					ec = j;
				}
			}
		}
		que.offer(new int[] {sr,sc,1,0});
		visited[sr][sc] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[0] == er && cur[1] == ec && cur[2] == 1) {
				time = cur[3];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || forest[nr][nc] == '*' || forest[nr][nc] == 'X') continue;
				if (cur[2] == 1) {
					if(visited[nr][nc] ) continue;
					que.offer(new int[] {nr,nc,1,cur[3]+1});
					visited[nr][nc] = true;
				} else {
					if (forest[nr][nc] == 'D') continue;
					que.offer(new int[] {nr,nc,0,0});					
					forest[nr][nc] = '*';
				}
			}
		}
		if (visited[er][ec]) {
			System.out.println(time);
		} else {
			System.out.println("KAKTUS");
		}
		
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}

}
