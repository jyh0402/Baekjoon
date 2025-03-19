import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] count;
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		count = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b - 1].add(a - 1);
		}
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];

			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.offer(i);
			visited[i] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int next : graph[cur]) {
					if (!visited[next]) {
						visited[next] = true;
						q.offer(next);
						count[i]++;
					}
				}
			}
			max = Math.max(max, count[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (count[i] < max)
				continue;
			sb.append((i + 1) + " ");
		}
		System.out.print(sb);
	}

}
