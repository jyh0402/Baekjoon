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
		Acnt = A;
		Bcnt = B;
		int pos = 0;
		for (int i = 0; i < A; i++) {
			int a = Alst.get(i);
			while (pos < B) {
				int b = Blst.get(pos);
				if (a == b) {
					Acnt--;
					pos++;
					break;
				} else if (a > b) {
					pos++;
				} else {
					break;
				}
			}
		}
		pos = 0;
		for (int i = 0; i < B; i++) {
			int b = Blst.get(i);
			while (pos < A) {
				int a = Alst.get(pos);
				if (a == b) {
					Bcnt--;
					pos++;
					break;
				} else if (b > a) {
					pos++;
				} else {
					break;
				}
			}
		}
		int sum = Acnt+Bcnt;
		System.out.println(sum);
	}

}
