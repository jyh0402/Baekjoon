import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] connect;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		connect = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			check(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(connect[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void check(int index) {
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			if (map[index][i] == 1) {
				que.offer(i);
				connect[index][i] = 1;
			}
		}
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 0; i < N; i++) {
				if (map[cur][i] == 1 && connect[index][i] == 0) {
					connect[index][i] = 1;
					if (i == index)	continue;
					que.offer(i);
									
				}
			}
		}
		
	}
}
