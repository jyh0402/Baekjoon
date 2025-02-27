import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] water;
	static int cr,cc;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static boolean[][] visited;
	static int size;
	static int eat;
	static int time;
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		water = new int[N][N];
		size = 2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
				if (water[i][j] == 9) {
					cr = i;
					cc = j;
					water[i][j] = 0;
				}
			}
		}
		while(bfs());
		
		System.out.println(time);
	}
	private static boolean bfs() throws InterruptedException {
		visited = new boolean[N][N];
		int shortest = 1000;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		ArrayList<int[]> lst = new ArrayList<>();
		q.offer(new int[] {cr,cc,0});
		visited[cr][cc] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[2] > shortest) continue;
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (!check(nr,nc) || water[nr][nc] > size || visited[nr][nc]) continue;
				if (water[nr][nc] < size && water[nr][nc] != 0) {
				    int nd = cur[2] + 1;
				    if (nd < shortest) {
				        shortest = nd;
				        lst.clear();  // 이전 후보들을 모두 제거
				        lst.add(new int[] {nr, nc, nd});
				    } else if (nd == shortest) {
				        lst.add(new int[] {nr, nc, nd});
				    }
				}
				q.offer(new int[] {nr,nc,cur[2]+1});
				visited[nr][nc] = true;
			}
		}
		if (!lst.isEmpty()) {
			cr = lst.get(0)[0];
			cc = lst.get(0)[1];
			int tmp = lst.get(0)[2];
			for (int i = 1; i < lst.size(); i++) {
				if (cr > lst.get(i)[0]) {
					cr = lst.get(i)[0];
					cc = lst.get(i)[1];
					tmp = lst.get(i)[2];
				} else if (cr == lst.get(i)[0] && cc > lst.get(i)[1]) {

					cc = lst.get(i)[1];
				}
			}
			time += tmp;
			water[cr][cc] = 0;
			eat++;
			if (eat == size) {
				size++;
				eat = 0;
			}
			return true;
		}
		return false;
	}
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

}