import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] box;
	static ArrayList<int[]> lst;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int time;
	static int tomato;
	static ArrayDeque<int[]> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					lst.add(new int[] {i,j});
				} if (box[i][j] == 0) tomato++;
			}
		}

		bfs();
		if (tomato == 0) {
			System.out.println(time);
		} else {
			System.out.println(-1);
		}
	}
	private static void bfs() {
		que = new ArrayDeque<>();
		for (int i = 0; i < lst.size(); i++) {
			int[] start = lst.get(i);
			que.offer(new int[] {start[0],start[1],0});
		}
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || box[nr][nc] != 0) continue;
				que.offer(new int[] {nr,nc,cur[2]+1});
				time = Math.max(time, cur[2]+1);
				box[nr][nc] = 1;
				tomato--;
			}

		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}
