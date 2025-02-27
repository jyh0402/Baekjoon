import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int minr,minc;
	static int K;
	static int[] dir;
	static int[] length;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		minr = 1000;
		minc = 1000;
		dir = new int[6];
		length = new int[6];
		int ridx = 0;
		int cidx = 0;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i]= Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
			if(dir[i] < 3) {
				if (length[i] > R) {
					R = Math.max(length[i], R);
					ridx = i;
				}
				
			} else {
				if (length[i] > C) {
					C = Math.max(length[i], C);
					cidx = i;
				}
				
			}
		}
		minr = Math.abs(length[(cidx+1) % 6]-length[(cidx+5)%6]);
		minc = Math.abs(length[(ridx+1) % 6]-length[(ridx+5)%6]);
		
		System.out.println((R*C - minr * minc) * K);
	}

}
