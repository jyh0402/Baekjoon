import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int cnt;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		bfs(N);
		System.out.println(cnt);
	}
	private static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		q.offer(0);
		visited[n] = true;
		while(!q.isEmpty()) {
			int next = (int) q.poll();
			int num = (int) q.poll();
			if (next == K) {
				cnt = num;
				return;
			}
			int nn = next - 1;
			if (nn >= 0 && visited[nn] == false) {
				q.offer(nn);
				q.offer(num+1);
				visited[nn] = true;
			}
			nn = next + 1;
			if (nn <= 100000 && visited[nn] == false) {
				q.offer(nn);
				q.offer(num+1);
				visited[nn] = true;
			}
			
			nn = next * 2;
			if (nn <= 100000 && visited[nn] == false) {
				q.offer(nn);
				q.offer(num+1);
				visited[nn] = true;
			}
			
			
		}
	}

}
