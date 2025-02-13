import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w,h;
	static int[][] map;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			
			cnt = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						ff(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	private static void ff(int i, int j) {
		Queue q = new ArrayDeque<>();
		q.offer(i);
		q.offer(j);
		while(!q.isEmpty()) {
			int r = (int) q.poll();
			int c = (int) q.poll();
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];				
				if (nr>=0 && nr <h && nc >= 0 && nc < w && map[nr][nc] == 1) {
					map[nr][nc] += cnt;
					q.offer(nr);
					q.offer(nc);
				}
			}
		}
	}

}
