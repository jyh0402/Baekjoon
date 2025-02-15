import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map;
	static int min;
	static ArrayList<int[]> chk;
	static ArrayList<int[]> home;
	static ArrayList<int[]> leftchk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		min = 100000;
		
		chk = new ArrayList<>();
		home = new ArrayList<>();
		leftchk = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) {
					chk.add(new int[] {i,j});
				}
				if (map[i][j] == 1) {
					home.add(new int[] {i,j});
				}
			}
		}
		
		subset(0, 0);
		
		System.out.println(min);
	}
	private static void subset(int n, int cnt) {
		if (n == chk.size()) {
			if (cnt == M) {
				min = cktot();
			}
			return;
		}
		int[] cur = chk.get(n);
		leftchk.add(new int[] {cur[0], cur[1]});
		subset(n + 1, cnt+1);
		leftchk.remove(leftchk.size()-1);
		subset(n + 1,  cnt);
	}
	private static int cktot() {
		int tot = 0;
		for (int i = 0; i < home.size(); i++) {
			int chkmin = 100000;
			int[] h = home.get(i);
			int hr = h[0];
			int hc = h[1];
			for (int j = 0; j < leftchk.size(); j++) {
				int[] c = leftchk.get(j);
				int cr = c[0];
				int cc = c[1];
				chkmin = Math.min(Math.abs(hr-cr) + Math.abs(hc-cc), chkmin);
			}
			tot += chkmin;
            if (tot >= min) return min;
		}
		return Math.min(min, tot);
	}

}
