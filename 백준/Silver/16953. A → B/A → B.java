import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static long A,B;
	static long cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(cnt);
	}
	private static void bfs() {
		ArrayDeque<long[]> q = new ArrayDeque<>();
		q.offer(new long[] {A,0});
		while(!q.isEmpty()) {
			long[] cur = q.poll();
			if (cur[0] == B) {
				cnt = cur[1]+1;
				return;
			}
			if (cur[0] * 2 <= B) {
				q.offer(new long[] {cur[0] * 2, cur[1] +1});
			}
			if (cur[0] * 10 + 1 <= B) {
				q.offer(new long[] {cur[0] * 10 + 1, cur[1] +1});
			}
		}
		cnt = -1;
	}

}
