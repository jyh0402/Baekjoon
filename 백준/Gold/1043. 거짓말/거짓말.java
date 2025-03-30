import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[] truth;
	static int[] p;
	static int[] start;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		start = new int[M];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		truth = new boolean[N];
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken()) - 1;
			truth[k] = true;
		}
		
		for (int i = 0; i < M; i++) {
			cnt++;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start[i] = Integer.parseInt(st.nextToken()) -1 ;
			for (int j = 1; j < n; j++) {
				int next = Integer.parseInt(st.nextToken()) - 1;
				Union(start[i],next);
			}
		}
		for (int i = 0; i < M; i++) {
			int p = find(start[i]);
			if (truth[p]) {
				cnt--;		
			}
		}
		System.out.println(cnt);
	}
	private static void Union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) {
			p[y] = x;			
		} else if (y < x) {
			p[x] = y;
		}
		if (truth[x] || truth[y]) {
			truth[x] = true;
			truth[y] = true;				
		}
		
	}
	private static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

}
