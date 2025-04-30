import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] Gear = new int[4][8];
	static int K,N,D;
	static int[] dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				Gear[i][j] = ch[j] - '0';
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());			
			N = Integer.parseInt(st.nextToken()) - 1;
			D = Integer.parseInt(st.nextToken());
			dir = new int[4];
			switch (N) {
			case 0: {
				dir[0] = D;
				if (Gear[0][2] != Gear[1][6]) dir[1] = (-1) * dir[0];
				else break;
				if (Gear[1][2] != Gear[2][6]) dir[2] = (-1) * dir[1];
				else break;
				if (Gear[2][2] != Gear[3][6]) dir[3] = (-1) * dir[2];
				break;
			}
			case 1: {
				dir[1] = D;
				if (Gear[0][2] != Gear[1][6]) dir[0] = (-1) * dir[1];
				if (Gear[1][2] != Gear[2][6]) dir[2] = (-1) * dir[1];
				else break;
				if (Gear[2][2] != Gear[3][6]) dir[3] = (-1) * dir[2];
				break;
			}
			case 2: {
				dir[2] = D;
				if (Gear[2][2] != Gear[3][6]) dir[3] = (-1) * dir[2];
				if (Gear[1][2] != Gear[2][6]) dir[1] = (-1) * dir[2];
				else break;				
				if (Gear[0][2] != Gear[1][6]) dir[0] = (-1) * dir[1];
				break;
			}
			case 3: {
				dir[3] = D;
				if (Gear[2][2] != Gear[3][6]) dir[2] = (-1) * dir[3];
				else break;
				if (Gear[1][2] != Gear[2][6]) dir[1] = (-1) * dir[2];
				else break;
				if (Gear[0][2] != Gear[1][6]) dir[0] = (-1) * dir[1];
				break;
			}
			}
			for (int j = 0; j < 4; j++) {
			    int d = dir[j];
			    if (d == -1) {
			        // 한 칸 왼쪽 회전
			        int temp = Gear[j][0];
			        for (int k = 0; k < 7; k++) {
			            Gear[j][k] = Gear[j][k+1];
			        }
			        Gear[j][7] = temp;
			    } else if (d == 1) {
			        // 한 칸 오른쪽 회전
			        int temp = Gear[j][7];
			        for (int k = 7; k > 0; k--) {
			            Gear[j][k] = Gear[j][k-1];
			        }
			        Gear[j][0] = temp;
			    }
			}
		}
		int sum = 0, n = 1;
		for (int i = 0; i < 4; i++) {
			if (Gear[i][0] == 1) sum+=n;
			n *= 2;
		}
		System.out.println(sum);
	}

}