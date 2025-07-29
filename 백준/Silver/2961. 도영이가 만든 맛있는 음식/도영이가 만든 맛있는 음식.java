import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] p;
	static int N;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		p = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}
		food(0,1,0,0);
		System.out.println(min);
	}
	private static void food(int cnt, int mul, int tot, int num) {
		if (cnt == N) {
			if (num == 0) return;
			min = min < Math.abs(tot - mul)? min : Math.abs(tot - mul);
			return;
		}
		food(cnt+1,mul * p[cnt][0], tot + p[cnt][1], num+1);
		food(cnt+1,mul,tot,num);
	}

}
