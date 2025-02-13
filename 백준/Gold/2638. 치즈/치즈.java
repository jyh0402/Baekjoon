import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] paper;
	static int[][] copy;
	static int time;
	static boolean cheese;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] =Integer.parseInt(st.nextToken());
				if (paper[i][j] == 1) cheese = true;
			}
		}
		
		while(cheese) {
			//다른 배열에 복사
			for (int i = 0; i < N; i++) {
				System.arraycopy(paper[i], 0 ,copy[i] ,0, M);
			}
			mark();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 1) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if (nr >=0 && nr < N && nc >= 0 && nc <M) {
								if (copy[nr][nc] == 2) {
									cnt++;
									if (cnt == 2) break;
								}
							}
						}
						if (cnt == 2) {
							copy[i][j] = 3;
						}
					}
				}
			}			
			
			cheese = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if (copy[i][j] == 1) {
						cheese = true;
						paper[i][j] = copy[i][j];
					} else {
						paper[i][j] = 0;
					}
					
				}
			}
			time++;
		}
		
		System.out.println(time);
	}
	//공기의 내부/외부 구별
	private static void mark() {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(0);
		que.offer(0);
		while(!que.isEmpty()) {
			int r =que.poll();
			int c =que.poll();
			if (copy[r][c] == 1 || copy[r][c] == 2) continue;
			copy[r][c] = 2;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >=0 && nr < N && nc >= 0 && nc <M) {
					que.offer(nr);
					que.offer(nc);
				}
			}
		}
		
	}
	
	
}
