import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,H;
	static int[][][] box;
	static ArrayList<int[]> lst;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int[] dh = {-1,1};
	static int time;
	static int tomato;
	static ArrayDeque<int[]> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H];
		lst = new ArrayList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[i][j][h] = Integer.parseInt(st.nextToken());
					if (box[i][j][h] == 1) {
						lst.add(new int[] {i,j,h});
					} if (box[i][j][h] == 0) tomato++;
				}
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
			que.offer(new int[] {start[0],start[1],start[2],0});
		}
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || box[nr][nc][cur[2]] != 0) continue;
				que.offer(new int[] {nr,nc,cur[2],cur[3]+1});
				time = Math.max(time, cur[3]+1);
				box[nr][nc][cur[2]] = 1;
				tomato--;
			}
			for (int d = 0; d < 2; d++) {
				int nh = cur[2] + dh[d];
				if (nh >= 0 && nh < H && box[cur[0]][cur[1]][nh] == 0) {
					que.offer(new int[] {cur[0],cur[1],nh,cur[3]+1});
					box[cur[0]][cur[1]][nh] = 1;
					time = Math.max(time, cur[3]+1);
					tomato--;
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}
