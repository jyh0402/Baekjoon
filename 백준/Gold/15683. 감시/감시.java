import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int max,min;
	static ArrayList<int[]> lst = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		min = N*M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 6) min--;
				if (map[i][j] > 0 && map[i][j] < 6) {
					lst.add(new int[] {i,j,map[i][j]});
				}
			}
		}
		BT(0);
		System.out.println(min);
	}
	private static void BT(int depth) {
		if (depth == lst.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) cnt++;
				}				
			}
			min = Math.min(min, cnt);
			return;
		}
		int[] cur = lst.get(depth);
		int r = cur[0];
		int c = cur[1];
		if (cur[2] == 1) {
			for (int d = 0; d < 4; d++) {
				setLine(r,c,d,2);
				BT(depth+1);
				setLine(r,c,d,1);
			}
		} else if (cur[2] == 2) {
			for (int d = 0; d < 2; d++) {
				setLine(r,c,d,2);
				setLine(r,c,d+2,2);
				BT(depth+1);				
				setLine(r,c,d+2,1);
				setLine(r,c,d,1);
			}
			
		} else if (cur[2] == 3) {
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < 2; i++) {
					int nd = (d + i) % 4;
					setLine(r,c,nd,2);
				}
				BT(depth+1);
				for (int i = 0; i < 2; i++) {
					int nd = (d + i) % 4;
					setLine(r,c,nd,1);
				}
			}
			
		} else if (cur[2] == 4) {
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < 3; i++) {
					int nd = (d + i) % 4;
					setLine(r,c,nd,2);
				}
				BT(depth+1);
				for (int i = 0; i < 3; i++) {
					int nd = (d + i) % 4;
					setLine(r,c,nd,1);
				}
			}
		} else if (cur[2] == 5) {
			for (int d = 0; d < 4; d++) {
				setLine(r,c,d,2);
			}
			BT(depth+1);
			for (int d = 0; d < 4; d++) {
				setLine(r,c,d,1);
			}
		}
		
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
	private static void setLine(int r, int c, int d, int mode) {
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (!check(nr,nc)) break;
			if (map[nr][nc] == 6) break;
			if (mode == 1) { //1번이 지우기 2번이 채우기
				if (map[nr][nc] < 0) {
					map[nr][nc]++;
				}
			} else {
				if (map[nr][nc] <= 0) {
					map[nr][nc]--;
				}
			}
			
			
		}
	}

}
