import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int D,N;
	static int[] oven,minoven;
	static boolean[] ovenpizza;
	static int[] pizza;
	static int pizzacnt, ovencnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		if (N > D) {
			System.out.println(0);
			return;
		}
		oven = new int[D];
		minoven = new int[D];
		pizza = new int[N];
		ovencnt = D-1;
		pizzacnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}
		minoven[0] = oven[0];
		for (int i = 1; i < D; i++) {
			minoven[i] = Math.min(oven[i], minoven[i-1]);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());			
		}
		while (ovencnt != -1 && pizzacnt < N) {
			if (minoven[ovencnt] < pizza[pizzacnt]) ovencnt--;
			else {
				ovencnt--;
				pizzacnt++;
			}
		}
		if (pizzacnt != N) {
			System.out.println(0);
		} else {
			System.out.println(ovencnt+2);
		}
		
	}

}
