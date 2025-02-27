import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int[][][] move;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		move = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j] - '0';
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {0,0,0,1}); // r,c,벽,거리
		move[0][0][0] = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc)) continue;
				if (map[nr][nc] == 1 && cur[2] == 0 && move[nr][nc][1] == 0) {
					q.offer(new int[] {nr,nc,1,cur[3]+1});
					move[nr][nc][1] = cur[3] + 1;
				} else if (map[nr][nc] == 0 && move[nr][nc][cur[2]] == 0) {
					q.offer(new int[] {nr,nc,cur[2],cur[3]+1});
					move[nr][nc][cur[2]] = cur[3] + 1;
				}
			}
		}
		if (move[N-1][M-1][0] == 0 && move[N-1][M-1][1] == 0) {
			System.out.println(-1);
		} else if (move[N-1][M-1][0] == 0){
			System.out.println(move[N-1][M-1][1]);
		} else if (move[N-1][M-1][1] == 0) {
			System.out.println(move[N-1][M-1][0]);
		} else {
			System.out.println(Math.min(move[N-1][M-1][0], move[N-1][M-1][1]));
		}
		
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
