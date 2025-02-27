import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A;
	static int min,max,cnt;
	static int[] cal;
	static int[] calcnt;
	static int[] C;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		calcnt = new int[4];
		C = new int[N-1];
		Arrays.fill(C, -1);
		int caln = 0;
		st = new StringTokenizer(br.readLine());
		cnt = 0;
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			calcnt[i] = n;
			cnt += n;
		}
		cal = new int[cnt];
		visited = new boolean[cnt];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < calcnt[i]; j++) {
				cal[caln++] = i;
				
			}
		}
		
		max = -1000000000;
		min = 1000000000;
		perm(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(int depth) {
		if (depth == N-1) {
			calc();
			return;
		}
		for (int i = 0; i < cal.length; i++) {
			if(visited[i]) continue;
            if (i > 0 && cal[i] == cal[i - 1] && !visited[i - 1]) continue;
			visited[i] = true;
			C[depth] = cal[i];
			perm(depth+1);
			C[depth] = -1;
			visited[i] = false;
		}
		
	}

	private static void calc() {
		int sum = A[0];
		for (int i = 0; i < N-1; i++) {
			switch (C[i]) {
			case 0: {
				sum += A[i+1];
				break;
			}
			case 1:{
				sum -= A[i+1];
				break;
			}
			case 2:{
				sum *= A[i+1];
				break;
			}
			case 3:{
				sum /= A[i+1];
				break;
			}
			}
		}
		min = Math.min(min, sum);
		max = Math.max(max, sum);
	}
}

