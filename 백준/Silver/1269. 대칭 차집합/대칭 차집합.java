import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int A,B,Acnt,Bcnt;
	static ArrayList<Integer> Alst,Blst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		Alst = new ArrayList<>();
		Blst = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			int n = Integer.parseInt(st.nextToken());
			Alst.add(n);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int n = Integer.parseInt(st.nextToken());
			Blst.add(n);
		}
		Alst.sort(null);
		Blst.sort(null);
        int i = 0, j = 0, cnt = 0;
        while (i < A && j < B) {
            int a = Alst.get(i), b = Blst.get(j);
            if (a < b) {
                cnt++;
                i++;
            } else if (a > b) {
                cnt++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        cnt += (A - i) + (B - j);
		System.out.println(cnt);
	}

}
