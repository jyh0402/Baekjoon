import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H,W,X,Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		int R = H+X;
		int C = W+Y;
		int[][] A = new int[H][W];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (i < H && j < W) {
                    if (i >= X && j >= Y) {
                        v -= A[i - X][j - Y];
                    }
                    A[i][j] = v;
                }
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
