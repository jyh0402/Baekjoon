import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map,copy;
	static int time = 1, cnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			copy = new int[N][M];
			int max = 0;
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if (map[i][j] == 0) continue;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (map[nr][nc] == 0) {
							copy[i][j]++;
						}
					}
				}
			}			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if (map[i][j] == 0) continue;
					map[i][j] = Math.max(map[i][j] - copy[i][j], 0);
					max = Math.max(max, map[i][j]);
				}
			}
			cnt = 1;
			copy = new int[N][M];
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if (map[i][j] == 0 || copy[i][j] != 0) continue;
					FF(i,j);
				}
			}
			if (cnt > 2) {
				break;
			}
			time++;
			if (max == 0) {
				time = 0;
				break;
			}
		}
		System.out.println(time);
	}
	private static void FF(int i, int j) {
		ArrayDeque<int[]> pq = new ArrayDeque<>();
		pq.offer(new int[] {i,j});
		copy[i][j] = cnt;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (copy[nr][nc] == 0 && map[nr][nc] > 0) {
					copy[nr][nc] = cnt;
					pq.offer(new int[] {nr,nc});
				}
			}
		}
		cnt++;
	}

}
