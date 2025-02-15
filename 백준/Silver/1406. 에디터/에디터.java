import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static ArrayDeque<Character> LeftStack;
	static ArrayDeque<Character> RightStack;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		
		LeftStack = new ArrayDeque<>();
		RightStack = new ArrayDeque<>();
		
		for (char c : str.toCharArray()) {
			LeftStack.push(c);
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			String strr = br.readLine();
			char input = strr.charAt(0);
			
			if (input == 'L') {
				if (!LeftStack.isEmpty()) {
					RightStack.push(LeftStack.pop());
				}
			} else if (input == 'D') {
				if (!RightStack.isEmpty()) {
					LeftStack.push(RightStack.pop());
				}
			} else if (input == 'B') {
				if (!LeftStack.isEmpty()) {
					LeftStack.pop();
				}
			} else if (input == 'P') {
				char ch = strr.charAt(2);
				LeftStack.push(ch);
			}
		}
		while(!LeftStack.isEmpty()) {
			RightStack.push(LeftStack.pop());
		}
		StringBuilder sb = new StringBuilder();
		while(!RightStack.isEmpty()) {
			sb.append(RightStack.pop());
		}
		System.out.println(sb);
	}

}
