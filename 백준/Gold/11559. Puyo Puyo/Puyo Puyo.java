import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	static char[][] map;
	static int cnt;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static ArrayDeque<int[]> lst;
	static boolean combo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		while(true) {
			combo = false;
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						FF(i,j);
					}
				}
			}
			if (!combo) break;
			cnt++;
			for (int c = 0; c < 6; c++) {
				for (int r = 11; r >= 0; r--) {
					move(r,c);
				}
			}
		}
		System.out.println(cnt);
	}
	private static void move(int r, int c) {
		char color = map[r][c];
		map[r][c] = '.';
		int nr = r;
		int nc = c;
		for (int i = 0; i < 11-r; i++) {
			nr += 1;
			if (!check(nr,nc) || map[nr][nc] != '.') {
				nr -= 1;
			}
		}
		map[nr][nc] = color;
	}
	private static void FF(int r, int c) {
		char color = map[r][c];
		map[r][c] = '.';
		lst = new ArrayDeque<>();
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {r,c});
		lst.offer(new int[] {r,c});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || map[nr][nc] != color) continue;
				que.offer(new int[] {nr,nc});
				lst.offer(new int[] {nr,nc});
				map[nr][nc] = '.';
			}
		}
		if (lst.size() >= 4) {
			combo = true;			
		} else {
			while(!lst.isEmpty()) {
				int[] cur = lst.poll();
				map[cur[0]][cur[1]] = color;
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < 12 && nc < 6;
	}

}
