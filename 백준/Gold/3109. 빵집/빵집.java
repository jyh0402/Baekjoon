import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1,0,1,};
	static int dx = 1;
	static int R;
	static int C;
	static char[][] board;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			dfs(i,0);
		}
		
		System.out.println(cnt);
	}
	private static boolean dfs(int r, int c) {
		
		for (int i = 0; i < 3 ; i++) {
			int nr = r+dy[i];
			int nc = c+dx;
			if (nr>=0 && nr < R && board[nr][nc] == '.') {
				board[nr][nc] = 'x';
                if (nc == C-1) {
			        cnt++;
			        return true;
		        }
				if (dfs(nr,nc)) return true;
			}
		}
		return false;
	}

}
