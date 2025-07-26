import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[] ch;
	static boolean[] visited;
	static int[] High,Low;
	static boolean found;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		ch = new char[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    ch[i] = st.nextToken().charAt(0);
		}
		visited = new boolean[10];
		High = new int[N+1];
		BTH(0);
		found = false;
		visited = new boolean[10];
		Low = new int[N+1];
		BTL(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N+1; i++) {
			sb.append(High[i]);
		}
		sb.append("\n");
		for (int i = 0; i < N+1; i++) {
			sb.append(Low[i]);
		}
		System.out.println(sb);
	}
	private static void BTL(int depth) {
		if (depth == N+1 || found) {
			found = true;
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (visited[i] || found) continue;
			if (depth > 0) {
				if (ch[depth-1] == '>') {
					if (Low[depth-1] > i) {
						Low[depth] = i;
						visited[i] = true;
						BTL(depth+1);
						visited[i] = false;
					}
				} else if (ch[depth-1] == '<') {
					if (Low[depth-1] < i) {
						Low[depth] = i;
						visited[i] = true;
						BTL(depth+1);
						visited[i] = false;
					}
				}
			} else {
				Low[depth] = i;
				visited[i] = true;
				BTL(depth+1);
				visited[i] = false;
			}
		}
	}
	private static void BTH(int depth) {
		if (depth == N+1 || found) {
			found = true;
			return;
		}
		for (int i = 9; i >= 0; i--) {
			if (visited[i] || found) continue;
			if (depth > 0) {
				if (ch[depth-1] == '>') {
					if (High[depth-1] > i) {
						High[depth] = i;
						visited[i] = true;
						BTH(depth+1);
						visited[i] = false;
					}
				} else if (ch[depth-1] == '<') {
					if (High[depth-1] < i) {
						High[depth] = i;
						visited[i] = true;
						BTH(depth+1);
						visited[i] = false;
					}
				}
			} else {
				High[depth] = i;
				visited[i] = true;
				BTH(depth+1);
				visited[i] = false;
			}
		}
	}

}
