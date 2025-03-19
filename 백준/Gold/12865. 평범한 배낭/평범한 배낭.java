import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K,W,V;
	static int[][] thing;
	static int[][] bag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		thing = new int[N][2];
		bag = new int[N][K+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			thing[i][0] = Integer.parseInt(st.nextToken()); //무게
			thing[i][1] = Integer.parseInt(st.nextToken()); //가치
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if (i == 0) {
					if (thing[i][0] <= j) bag[i][j] = thing[i][1];	
				} else if (thing[i][0] <= j) {
					bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-thing[i][0]] + thing[i][1]);
				} else {
					bag[i][j] = bag[i-1][j];
				}
			}
		}
		System.out.println(bag[N-1][K]);
	}

}
