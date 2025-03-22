import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] score;
	static long min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		score = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score);
		
		for (int i = 0; i < N; i++) {
			min += Math.abs(i+1 - score[i]);
		}
		System.out.println(min);
	}

}
