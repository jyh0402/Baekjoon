import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BigInteger ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
		
			int n = Integer.parseInt(st.nextToken());
		
			if (n == 0) {
				System.out.println(1);
			}else {
				BigInteger twoval = BigInteger.valueOf(2).pow(n+1);
				BigInteger oneval = BigInteger.valueOf(-1).pow(n-1);
		
				ans = twoval.subtract(oneval);
				ans = ans.divide(BigInteger.valueOf(3));
				System.out.println(ans);
			}
		}
		
	}

}