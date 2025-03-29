import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int T,N;
	static int[] man;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());			
			man = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken())-1;
				int iv = Integer.parseInt(st.nextToken())-1;
				man[doc] = iv;
			}
			int rank = man[0];
			int cnt = 1;
			for (int i = 1; i < N; i++) {
				if (rank > man[i]) {
					cnt++;
					rank = man[i];
				}
				
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

}
