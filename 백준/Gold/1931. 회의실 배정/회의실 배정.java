import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static PriorityQueue<Meeting> pq;
	static int cnt;
	static class Meeting implements Comparable<Meeting>{
		int start,end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int Mstart = Integer.parseInt(st.nextToken());
			int Mend = Integer.parseInt(st.nextToken());
			pq.add(new Meeting(Mstart, Mend));
		}
		Meeting curM = pq.poll();
		cnt++;
		Meeting prvM = curM;
		while(!pq.isEmpty()) {
			curM = pq.poll();
			if (curM.start < prvM.end) continue;
			cnt++;
			prvM = curM;
		}
		System.out.println(cnt);
	}

}
