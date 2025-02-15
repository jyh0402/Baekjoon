import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Character> LeftStack;
	static Stack<Character> RightStack;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		
		LeftStack = new Stack<>();
		RightStack = new Stack<>();
		
		for (char c : str.toCharArray()) {
			LeftStack.push(c);
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if (input.equals("L")) {
				if (!LeftStack.isEmpty()) {
					RightStack.push(LeftStack.pop());
				}
			} else if (input.equals("D")) {
				if (!RightStack.isEmpty()) {
					LeftStack.push(RightStack.pop());
				}
			} else if (input.equals("B")) {
				if (!LeftStack.isEmpty()) {
					LeftStack.pop();
				}
			} else if (input.equals("P")) {
				char ch = st.nextToken().charAt(0);
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
