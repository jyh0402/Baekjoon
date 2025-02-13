import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int testcase;
	static int I;
	static int[][] board;
	static int sr,sc;
	static int[] dr = {-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {-1,-2,-2,-1,1,2,2,1};
	static boolean[][] visited;
	static int count;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		testcase = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < testcase; i++) {
			st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());
			board = new int[I][I];
			visited = new boolean[I][I];
			count = 0;
			
			st = new StringTokenizer(br.readLine());		
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			visited[sr][sc] = true;
			
			st = new StringTokenizer(br.readLine());		
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			board[er][ec] = 1;
			if (sr == er && sc == ec) {
				System.out.println(0);
				continue;
			}
			
			bfs(sr,sc);
			
			
			System.out.println(count);
		}		
		
	}

	private static void bfs(int sr2, int sc2) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(sr2);
		que.offer(sc2);
		que.offer(count);
		while (!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			int ncount = que.poll();
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr>=0 && nr <I && nc >= 0 && nc < I && visited[nr][nc] == false) {
					if (board[nr][nc] == 1) {
						count = ncount+1;
						return;
					}
					visited[nr][nc] = true;
					que.add(nr);
					que.add(nc);
					que.add(ncount+1);
				}
			}
		}
		
	}
}
