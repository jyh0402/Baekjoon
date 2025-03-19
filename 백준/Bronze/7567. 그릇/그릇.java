import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String input;
	static int height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		char prev = '0';
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (prev == ch) {
				height += 5;
			} else {
				height += 10;
				prev = ch;
			}
        }
		System.out.println(height);
	}
}
