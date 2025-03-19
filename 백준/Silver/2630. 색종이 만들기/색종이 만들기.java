import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cnt = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		paper(0,0,N-1,N-1);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}
	private static void paper(int r1, int c1, int r2, int c2) {
		int color = map[r1][c1];
		if (r1 == r2 && c1 == c2) {
			cnt[color]++;
			return;
		}
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				if (color != map[i][j]) {
					int rhalf = (r2-r1)/2;
					int chalf = (c2-c1)/2;
					paper(r1,c1,r1 + rhalf,c1 + chalf);
					paper(r1,c2 - chalf,r1 + rhalf,c2);
					paper(r2 - rhalf,c1,r2,c1 + chalf);
					paper(r2 - rhalf,c2 - chalf,r2,c2);
					return;
				}
			}
		}
		cnt[color]++;
	}

}