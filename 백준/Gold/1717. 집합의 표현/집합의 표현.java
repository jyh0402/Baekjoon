import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] p;
	static int c,a,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		initSet();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (c == 0) {
				Union(a,b);
			} else if (c == 1) {
				if (find(a) == find(b)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}
	private static void Union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return;
		if (x < y) {
			p[y] = x;
		} else {
			p[x] = y;
		}
		
	}
	private static int find(int x) {
	    if (p[x] != x) { 
	        p[x] = find(p[x]);
	    }
	    return p[x];
	}

	private static void initSet() {
		p = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			p[i] = i;
		}
	}

}
