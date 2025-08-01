import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int T,M,N,K,cnt;
	static int[][] ground;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ground = new int[N][M];
			cnt = 0;
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[y][x] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ground[i][j] != 1) continue;
					FF(i,j);
					cnt++;
				}
			}
			
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	private static void FF(int i, int j) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		ground[i][j] = 2;
		que.add(new int[] {i,j});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || ground[nr][nc] != 1) continue;
				ground[nr][nc] = 2;
				que.add(new int[] {nr,nc});
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
