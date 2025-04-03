import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static char next;
	static ArrayDeque<Character> N,C;
	public static void main(String[] args) throws IOException {
		N = new ArrayDeque<>();
		C = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] ch = br.readLine().toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(') {
				C.push(ch[i]);
			} else if (ch[i] == '/' || ch[i] == '*') {
				if (!C.isEmpty() && (C.peek() == '*' || C.peek() == '/')) {
					N.offer(C.pop());
				}
				C.push(ch[i]);
			} else if (ch[i] == '+' || ch[i] == '-') {
				while(!C.isEmpty()) {
					next = C.pop();
					if (next == '(') {
						C.push(next);
						break;						
					}
					N.offer(next);
				}
				C.push(ch[i]);
			} else if (ch[i] == ')') {
				while(true) {
					next = C.pop();
					if (next == '(') {
						break;
					}
					N.offer(next);
				}
			} else {
				N.offer(ch[i]);
			}
			
		}
		while(!C.isEmpty()) {
			next = C.pop();
			N.offer(next);
		}
		while(!N.isEmpty()) {
			sb.append(N.poll());
		}
		System.out.println(sb);
	}

}
