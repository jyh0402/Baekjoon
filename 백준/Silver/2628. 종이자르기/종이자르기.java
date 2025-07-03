import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

public class Main {
	static int R,C,N;
	static ArrayList<Integer> Rlst,Clst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Rlst = new ArrayList<>();
		Clst = new ArrayList<>();
		Rlst.add(0);
		Rlst.add(R);
		Clst.add(0);
		Clst.add(C);
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			if (n == 1) {
				Rlst.add(a);
			} else {
				Clst.add(a);
			}
		}
		Rlst.sort(null);
		Clst.sort(null);
		
		int max = 0;
		
		for (int i = 1; i < Rlst.size(); i++) {
			int r = Rlst.get(i) - Rlst.get(i-1);
			
			for (int j = 1; j < Clst.size(); j++) {				
				int c = Clst.get(j) - Clst.get(j-1); 
				max = Math.max(max, r*c);
			}
		}
		System.out.println(max);
	}

}
