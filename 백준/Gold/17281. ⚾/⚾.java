import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] SK;
	static int[] lineup = {1,2,3,4,5,6,7,8};
	static int[] order;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		SK = new int[N][9];
		order = new int[9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				SK[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		do {
			cal();
		} while(np(7));
		System.out.println(max);
	}
	private static void cal() {
		for (int i = 0; i < 9; i++) {
			if (i < 3) {
				order[i] = lineup[i];
			} else if (i == 3) {
				order[i] = 0;
			} else {
				order[i] = lineup[i-1];
			}
		}
		
		int sum = 0;
		int Hitter = 0;
		for (int i = 0; i < N; i++) {
			int out = 0;
			int score = 0;
			int base = 0;
			while (out != 3) {
				int hit = SK[i][order[Hitter++]];
				if (Hitter == 9) Hitter = 0;
				if (hit == 0) {
					out++;
					continue;
				}
				base = (base << hit) | (1<<(hit-1));
				
				int runsScored = Integer.bitCount(base >> 3);
				score += runsScored;
				base = base & 7;
				
			}
			sum += score;
		}
		max = Math.max(max, sum);
	}
	private static boolean np(int size) {
		int i = size;
		while(i>0 && lineup[i-1] > lineup[i]) i--;
		if (i == 0) return false;
		int j = size;
		while(lineup[i-1] > lineup[j]) j--;
		int temp = lineup[j];
		lineup[j] = lineup[i-1];
		lineup[i-1] = temp;
		int k = size;
		while(i < k) {
			temp = lineup[k];
			lineup[k] = lineup[i];
			lineup[i] = temp;
			k--;
			i++;
		}
		return true;
	}

}
