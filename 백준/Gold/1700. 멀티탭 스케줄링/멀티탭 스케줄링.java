import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] use;
	static int[] plug;
	static int[] used;
	static int cnt;
	static boolean[] using;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N >= K) {
			System.out.println(0);
			return;
		}
		plug = new int[N];
		used = new int[N];
		use = new int[K];
		using = new boolean[K+1];
        int fill = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			use[i] = num;
		}
        
		for (int i = 0; i < K; i++) {
			if (using[use[i]]) continue;
			int index = 0, max = 0;
            if (fill != N){
                plug[fill++] = use[i];
                using[use[i]] = true;
                continue;
            }
			for (int j = 0; j < N; j++) {
				if (plug[j] == 0) {
					plug[j] = use[i];
					cnt--;
					index = j;
					break;
				}
				int n = 1;
				
				while((i+n)<K) {
					if (plug[j] == use[i + n]) {
						if (n > max) {
							max = n;
							index = j;
						}
						break;
					}
					n++;
				}
				if ((i+n) == K) {
					index = j;
					break;
				}
			}
			cnt++;
			using[plug[index]] = false;
			plug[index] = use[i];
			using[use[i]] = true;
		}
		System.out.println(cnt);
	}

}
