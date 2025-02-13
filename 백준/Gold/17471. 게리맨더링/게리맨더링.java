import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] city;
	static boolean[] visited;
	static int[][] graph;
	static int min = 100000;
	static boolean able;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		city = new int[N];
		visited = new boolean[N];
		graph = new int[N][N];
		
		st = new StringTokenizer(br.readLine());	
		for (int i = 0; i < N; i++) {					
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				int e =Integer.parseInt(st.nextToken());
				graph[i][e-1] = 1;
				graph[e-1][i] = 1;
			}
		}
		
		subset(0);
		if (min == 100000) System.out.println(-1);
		else System.out.println(min);
	}
	private static void subset(int cnt) {
		if (cnt == N) {
			int conns = conn(visited);
			//System.out.println(conns);
			min = Math.min(min, conns);
			//System.out.println(min);
			//System.out.println("================");
			return;
		}
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
	}
	
	private static int conn(boolean[] visit) {
		List<Integer> lista = new ArrayList<>();
		List<Integer> listb = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			if (visit[i] == true) {
				lista.add(i);
			} else {
				listb.add(i);
			}
		}
		
		//System.out.println(Arrays.toString(lista.toArray()));
		//System.out.println(Arrays.toString(listb.toArray()));
		
		if (check(lista) && check(listb)) {
			int suma = 0;
			int sumb = 0;
			for (int i = 0; i < lista.size(); i++) {
				suma += city[lista.get(i)];
			}
			for (int i = 0; i < listb.size(); i++) {
				sumb += city[listb.get(i)];
			}
			return Math.abs(suma - sumb);
		}
		return 100000;
	}
	
	private static boolean check(List<Integer> group) {
	    if (group.size() == 0) return false;
	    boolean[] visitedGroup = new boolean[N];
	    Queue<Integer> queue = new ArrayDeque<>();
	    
	    int start = group.get(0);
	    visitedGroup[start] = true;
	    queue.offer(start);
	    
	    while (!queue.isEmpty()) {
	        int cur = queue.poll();
	        for (int i = 0; i < N; i++) {if (graph[cur][i] == 1 && group.contains(i) && !visitedGroup[i]) {
	                visitedGroup[i] = true;
	                queue.offer(i);
	            }
	        }
	    }
	    for (int city : group) {
	        if (!visitedGroup[city]) return false;
	    }
	    return true;
	}


}
