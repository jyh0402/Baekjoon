import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] p;
	static int a,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		for (int i = 0; i < N-2; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			Union(a,b);
		}
		for (int i = 2; i <= N; i++) {
			if (find(1) != find(i)) {
				System.out.println(1 + " " + i);
				return;
			}
		}
		System.out.println("1 2");
	}
	private static void Union(int x, int y) {
		x = find(x);
		y = find(y);
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
	
}
