import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = Integer.MAX_VALUE/2;
	static int N,K,time;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100001];
		Arrays.fill(map, MAX);
		if (N > K) {
			System.out.println(N-K);
			return;
		}
		map[N] = 0;
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.offer(N);
		while(true) {
			int cur = que.poll();			
			time = map[cur];
			if (cur == K) {
				break;
			}
			if (cur + 1 <100001) {
				if (map[cur+1] > time+1) {
					map[cur+1] = time+1;
					que.offer(cur+1);
				}
				
			}
			if (cur - 1 >= 0) {
				if (map[cur-1] > time+1) {
					map[cur-1] = time+1;
					que.offer(cur-1);
				}
			} 
			if (cur * 2 < 100001) {
				if (map[cur * 2] > time) {
					map[cur * 2] = time;
					que.offer(cur * 2);
				}
			}
		}
		System.out.println(time);
	}

}
