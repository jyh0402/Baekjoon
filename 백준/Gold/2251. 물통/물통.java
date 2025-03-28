import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int A,B,C;
	static boolean[][][] water;
	static boolean[] ans;
	static ArrayDeque<int[]> que;
	static int a,b,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		water = new boolean[A+1][B+1][C+1];
		ans = new boolean[C+1];
		que = new ArrayDeque<>();
		que.offer(new int[] {0,0,C});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int move = 0;
			//A에서 옮긴다
			if (cur[0] != 0) {
				move = Math.min(cur[0], B-cur[1]);
				a = cur[0] - move;
				b = cur[1] + move;
				c = cur[2];
				if (!water[a][b][c]) {
					water[a][b][c] = true;
					if (a == 0) ans[c] = true;
					que.offer(new int[] {a,b,c});					
				}
				move = Math.min(cur[0], C-cur[2]);
				a = cur[0] - move;
				b = cur[1];
				c = cur[2] + move;
				if (!water[a][b][c]) {
					water[a][b][c] = true;
					if (a == 0) ans[c] = true;
					que.offer(new int[] {a,b,c});					
				}
			}
			//B에서 옮긴다
			if (cur[1] != 0) {
				move = Math.min(cur[1], A-cur[0]);
				a = cur[0] + move;
				b = cur[1] - move;
				c = cur[2];
				if (!water[a][b][c]) {
					water[a][b][c] = true;
					if (a == 0) ans[c] = true;
					que.offer(new int[] {a,b,c});					
				}
				move = Math.min(cur[1], C-cur[2]);
				a = cur[0];
				b = cur[1] - move;
				c = cur[2] + move;
				if (!water[a][b][c]) {
					water[a][b][c] = true;
					if (a == 0) ans[c] = true;
					que.offer(new int[] {a,b,c});					
				}
			}
			//C에서 옮긴다
			if (cur[2] != 0) {
				move = Math.min(cur[2], A-cur[0]);
				a = cur[0] + move;
				b = cur[1];
				c = cur[2] - move;
				if (!water[a][b][c]) {
					water[a][b][c] = true;
					if (a == 0) ans[c] = true;
					que.offer(new int[] {a,b,c});					
				}
				move = Math.min(cur[2], B-cur[1]);
				a = cur[0];
				b = cur[1] + move;
				c = cur[2] - move;
				if (!water[a][b][c]) {
					water[a][b][c] = true;
					if (a == 0) ans[c] = true;
					que.offer(new int[] {a,b,c});					
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < C+1; i++) {
			if (ans[i]) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}
	
}
