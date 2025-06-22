import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,start,end;
	static boolean[][] lst;
	static boolean[] visited;
	static int[] chon;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		lst = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		chon = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lst[x][y] = true;
			lst[y][x] = true;
		}
		ArrayDeque<Integer> que = new ArrayDeque<>();
		int cnt = 1;
		que.offer(start);
		visited[start] = true;
		chon[start] = 0;
		while(!que.isEmpty()) {
			int cur = que.poll();
			if (cur == end) break;
			for (int i = 1; i <= N; i++) {
				if (lst[cur][i] && !visited[i]) {
					que.offer(i);
					visited[i] = true;
					chon[i] = chon[cur] + 1;
				}
			}
			cnt++;
		}
		if (!visited[end]) chon[end] = -1;
		System.out.println(chon[end]);
	}

}
