import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static char[][] map;
	static int[][][] move;
	static int sr,sc,er,ec;
	static boolean out;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		move = new int[N][M][1<<6]; //좌표와 열쇠 보유
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0'){
					sr = i;
					sc = j;
				}
			}
		}
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {sr,sc,0,0});
		A : while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || move[nr][nc][cur[2]] != 0) continue;
				if (map[nr][nc] == '.' || map[nr][nc] == '0') {
					move[nr][nc][cur[2]] = cur[3]+1;
					dq.offer(new int[] {nr,nc,cur[2],cur[3]+1});
				} else if (map[nr][nc] == '1') {
					
					cnt = cur[3]+1;
					out = true;
					break A;
				} else if (map[nr][nc] >= 'a' && map[nr][nc] < 'z') {
					int key = map[nr][nc] - 'a';
					int nkey = cur[2] | (1 << key);
					move[nr][nc][nkey] = cur[3]+1;
					dq.offer(new int[] {nr,nc,nkey,cur[3]+1});
				} else if (map[nr][nc] >= 'A' && map[nr][nc] < 'Z') {
					int key = map[nr][nc] - 'A';
					if ((cur[2] & (1 << key)) != 0) {
						move[nr][nc][cur[2]] = cur[3]+1;
						dq.offer(new int[] {nr,nc,cur[2],cur[3]+1});
					}
				}
			}
		}
		
		if (out) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
