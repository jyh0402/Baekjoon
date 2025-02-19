import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] map;
	static int cnt;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N];
		Arrays.fill(map, -1);
		dfs(0);
		System.out.println(cnt);
	}
	private static void dfs(int depth) {
		if (depth == N) {
			cnt++;
			return;
		}
		for (int r = 0; r < N; r++) {
			boolean meet = false;
			for (int i = 0; i < depth; i++) {
				if (map[i] == r || Math.abs(map[i]-r) == Math.abs(i-depth)) {
					meet = true;
					break;
				}
			}
			if (!meet) {
				map[depth] = r;
				dfs(depth+1);
				map[depth] = -1;
			}
		}
	}

}
