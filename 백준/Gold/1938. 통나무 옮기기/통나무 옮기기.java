import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<int[]> start;
	static ArrayList<int[]> end;
	static int dir, edir, min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		start = new ArrayList<>();
		end = new ArrayList<>();
		visited = new boolean[N][N][2];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B') {
					start.add(new int[] {i,j});
					map[i][j] = '0';
				} else if (map[i][j] == 'E') {
					end.add(new int[] {i,j});
					map[i][j] = '0';
				}
			}
		}
		if (start.get(0)[0] == start.get(1)[0]) {
			dir = 1;
		}
		if (end.get(0)[0] == end.get(1)[0]) {
			edir = 1;
		}
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {start.get(1)[0], start.get(1)[1], dir, 0});
		visited[start.get(1)[0]][start.get(1)[1]][dir] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if (cur[0] == end.get(1)[0] && cur[1] == end.get(1)[1] && cur[2] == edir) {
				min = cur[3];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || visited[nr][nc][cur[2]] || map[nr][nc] == '1' || !able(nr,nc,cur[2])) continue;
				visited[nr][nc][cur[2]] = true;
				que.offer(new int[] {nr,nc,cur[2],cur[3]+1});				
			}
			int nd = (cur[2] + 1) % 2;
			if (!checkAround(cur[0],cur[1]) || visited[cur[0]][cur[1]][nd]) continue;
			que.offer(new int[] {cur[0],cur[1],nd,cur[3]+1});
			visited[cur[0]][cur[1]][nd] = true;
		}
		System.out.println(min);
	}
	private static boolean checkAround(int r, int c) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int nr = r - 1 + i;
				int nc = c - 1 + j;
				if (!check(nr,nc) || map[nr][nc] == '1') return false;
			}
		}
		return true;
	}
	private static boolean able(int r, int c, int d) {
		for (int i = 0; i < 2; i++) {
			int nd = (d + i * 2) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			if (!check(nr,nc) || map[nr][nc] == '1') return false;
		}
		return true;
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

}
