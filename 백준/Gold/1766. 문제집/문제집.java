import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static ArrayList[] adj;
	static int[] inEdges;
	static int Notzeros;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		inEdges = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s].add(e);
			if (inEdges[e] == 0) Notzeros++;
			inEdges[e]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			if (inEdges[i] == 0) {
				pq.offer(i);
			}
		}
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur + " ");
			for (int i = 0; i < adj[cur].size(); i++) {
				int next = (int) adj[cur].get(i);
				inEdges[next]--;
				if (inEdges[next] == 0) {
					Notzeros--;
					pq.offer(next);
				}
			}
		}
		System.out.println(sb);
	}

}
