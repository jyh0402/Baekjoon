import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] lab;
	static boolean[][] check;
	static ArrayList<int[]> lst;
	static ArrayList<int[]> virus;
	static int[] arr;
	static int R;
	static int max;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = 3;
		lab = new int[N][M];
		arr = new int[R];
		lst = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 0) {
					lst.add(new int[] {i,j});
				} else if (lab[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		combi(0,0);
		System.out.println(max);
	}
	private static void combi(int depth, int start) {
		if (depth == R) {
			int tot = 0;
			for (int i = 0; i < R; i++) {
				int[] pos = lst.get(arr[i]);
				lab[pos[0]][pos[1]] = 1;
			}
			check = new boolean[N][M];
			for (int i = 0; i < virus.size(); i++) {
				FF(i);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!check[i][j] && lab[i][j] == 0) {
						tot++;
					}
				}
			}
			max = Math.max(max, tot);
			
			for (int i = 0; i < R; i++) {
				int[] pos = lst.get(arr[i]);
				lab[pos[0]][pos[1]] = 0;
			}
			return;
		}
		for (int i = start; i < lst.size(); i++) {
			arr[depth] = i;
			combi(depth+1,i+1);
			arr[depth] = 0;
		}
	}
	private static void FF(int i) {
		int[] cur = virus.get(i);
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {cur[0],cur[1]});
		check[cur[0]][cur[1]] = true;
		while(!q.isEmpty()) {
			cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || lab[nr][nc] != 0 || check[nr][nc]) continue;
				q.offer(new int[] {nr,nc});
				check[nr][nc] = true;
			}
		}
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
