import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int R,C,D;
	static int[][] room;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int cnt;
	static boolean end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		if (D % 2 == 1) D = (D+2) % 4;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt++;
		room[R][C] = -1;
		int dir = D;
		int r = R; 
		int c = C;
		while(!end) {
			int clean = 0;
			for (int d = 0; d < 4; d++) {
				int nd = (dir + d + 1) % 4;
				int nr = r + dr[nd];
				int nc = c + dc[nd];
				if (room[nr][nc] == 0) {
					room[nr][nc]--;
					cnt++;
					clean++;
					r = nr;
					c = nc;
					dir = nd;
					break;
				}
			}
			if (clean == 0) {
				int nd = (dir + 2) % 4;
				int nr = r + dr[nd];
				int nc = c + dc[nd];
				if (room[nr][nc] == 1) {
					end = true;
					break;
				}
				r = nr;
				c = nc;
			}
		}
		System.out.println(cnt);
	}
}
