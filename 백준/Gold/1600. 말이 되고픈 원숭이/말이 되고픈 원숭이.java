import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int W,H;
	static int[][] map;
	static int[][][] visited;
	
	static int[] hdr = {-2,-1,1,2,2,1,-1,-2};
	static int[] hdc = {-1,-2,-2,-1,1,2,2,1};
	static int[] mdr = {-1,0,1,0};
	static int[] mdc = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map =  new int[H][W];
		visited = new int[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int value = -1;
		
		Queue<int[]> q =  new ArrayDeque<>();
		for (int i = 0; i <= K; i++) {
			q.offer(new int[] {0,0,0,i});
		}
		for (int i = 0; i <= K; i++) {
			visited[0][0][i] = 1;
		}
		
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			int k = cur[3];
			if (r == H-1 && c == W-1) {
				value = cnt;
				break;
			}
			if (k != K) {
				for (int d = 0; d < 8; d++) {
					int nr = r + hdr[d];
					int nc = c + hdc[d];
					if (!check(nr,nc)) continue;
					if (visited[nr][nc][k+1] == 0 && map[nr][nc] == 0) {
						visited[nr][nc][k+1] = 1;
						q.offer(new int[] {nr,nc,cnt+1,k+1});
					}
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + mdr[d];
				int nc = c + mdc[d];
				if (!check(nr,nc)) continue;
				if (visited[nr][nc][k] == 0 && map[nr][nc] == 0) {
					visited[nr][nc][k] = 1;
					q.offer(new int[] {nr,nc,cnt+1,k});
				}
			}
			
		}
		System.out.println(value);
	
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}
}
