import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] water;
	static ArrayList<int[]> al;
	static int max;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	static int mr,mc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		water = new int[N][M];
		al = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
				if (water[i][j] == 1) {
					al.add(new int[] {i,j});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (water[i][j] == 0) {
					check(i,j);
				}
			}
		}
		System.out.println(max);
	}
	private static void check(int r, int c) {
		int min = 1000;
		for (int i = 0; i < al.size(); i++) {
			int[] cur = al.get(i);
			int dis = Math.max(Math.abs(r-cur[0]), Math.abs(c-cur[1]));
			min = Math.min(min, dis);
		}
		max = Math.max(max, min);
	}
}