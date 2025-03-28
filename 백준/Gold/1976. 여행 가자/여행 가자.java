import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int connect;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				connect = Integer.parseInt(st.nextToken());
				if (connect == 0) continue;
				union(i,j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int city = Integer.parseInt(st.nextToken()) - 1;
		int start = find(city);
		for (int i = 1; i < M; i++) {
			city = Integer.parseInt(st.nextToken()) - 1;
			if (find(city) != start) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (y > x) {
			p[y] = x;
		}
	}
	private static int find(int x) {
		if (x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

}
