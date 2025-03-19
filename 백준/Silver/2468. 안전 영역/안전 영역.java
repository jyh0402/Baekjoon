import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] flower;
	static boolean[][] safe;
	static int max,temp;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		flower = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				flower[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int al = 0;
		while(al < 101) { //혹시 몰라서 해두는 안전장치
			safe = new boolean[N][N];
			temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (flower[i][j] > al && !safe[i][j]) {
						ff(i,j,al);
						temp++;
					}
				}
			}
			max = Math.max(max,temp);
			al++;
		}
		System.out.println(max);
	}
	private static void ff(int r, int c, int al) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		safe[r][c] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || safe[nr][nc] || flower[nr][nc] <= al) continue;
				q.offer(new int[] {nr,nc});
				safe[nr][nc] = true;
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

}
