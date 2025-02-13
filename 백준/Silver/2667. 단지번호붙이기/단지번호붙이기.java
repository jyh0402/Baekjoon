import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	
	static int N;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt; //단지의 개수
	static int[] num; //각 단지에 집이 몇개 있는지. num[1]에는 출력을 위해 cnt를 입력
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];		
		visited = new int[N][N];		
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			char[] cst = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = cst[j] - '0';
			}
		}
		
		//Flood Fill
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					floodfill(i,j);					
				}
				
			}
		}
		
		// 출력
		num = new int[cnt];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]>0) {
					num[map[i][j]-2]++;
				}
				
			}
		}
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		for (int i = 0; i < cnt; i++) {
			sb.append("\n" + num[i]);
		}
		System.out.println(sb);

	}

	private static void floodfill(int r, int c) {		
		map[r][c]+=cnt;
		for (int d = 0; d < 4; d++) {
			int nr = r +dr[d];
			int nc = c +dc[d];
			if (!check(nr,nc)) continue;
			if (map[nr][nc] == 0) continue;
			if (map[nr][nc] == 1) floodfill(nr, nc);
		}
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c >= 0 && c < N;
	}

}
