import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A;
	static int min,max;
	static int[] cal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		cal = new int[N-1];
		int caln = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				cal[caln++] = i;
				
			}
		}
		
		max = -1000000000;
		min = 1000000000;
		do {
			calc();
		}while(np(N-2));
		
		System.out.println(max);
		System.out.println(min);
	}
	private static boolean np(int size) {
		int i = size;
		while(i>0 && cal[i-1]>=cal[i]) i--;
		if (i==0) return false;
		int j = size;
		while(cal[i-1]>=cal[j]) j--;
		int temp = cal[i-1];
		cal[i-1] = cal[j];
		cal[j] = temp;
		int k = size;
		while(i<k) {
			temp = cal[i];
			cal[i] = cal[k];
			cal[k] = temp;
			i++;
			k--;
		}
		return true;
	}
	private static void calc() {
		int sum = A[0];
		for (int i = 0; i < N-1; i++) {
			switch (cal[i]) {
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
