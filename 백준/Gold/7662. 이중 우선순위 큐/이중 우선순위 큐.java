import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int T,Q;
	static TreeMap<Integer, Integer> tm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			Q = Integer.parseInt(st.nextToken());
			tm = new TreeMap<>();
			
			for (int q = 0; q < Q; q++) {
				st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				if (ch == 'I') {
					int inputI = Integer.parseInt(st.nextToken());
					if (tm.containsKey(inputI)) {
						int value = tm.get(inputI);
						tm.put(inputI, value+1);
					} else {
						tm.put(inputI, 1);
					}
				} else if (ch == 'D') {
					int inputD = Integer.parseInt(st.nextToken());
					if (tm.isEmpty()) continue;
					if (inputD == -1) {
						int key = tm.firstKey();
						int val = tm.get(key);
						if (val > 1) {
							tm.put(key, val-1);
						} else {
							tm.pollFirstEntry();
						}						
					} else if (inputD == 1) {
						int key = tm.lastKey();
						int val = tm.get(key);
						if (val > 1) {
							tm.put(key, val-1);
						} else {
							tm.pollLastEntry();
						}	
					}
				}
			}
			
			if (tm.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				
				System.out.print(tm.lastKey()+ " " + tm.firstKey() + "\n");
			}
			
		}
	}

}
