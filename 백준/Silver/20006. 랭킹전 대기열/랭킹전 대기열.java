import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int P,M;
	static class Player implements Comparable<Player> {
		int level;
		String name;
		
		public Player(int level,String name) {
			this.level = level;
		    this.name = name;
		}
		
		@Override
		public int compareTo(Player o) {
			return this.name.compareTo(o.name);
		}
		
	}
	static ArrayList<ArrayList<Player>> rooms = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		P = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Player player = new Player(level, name);
			boolean matched = false;
			
			for (int j = 0; j < rooms.size(); j++) {
				ArrayList<Player> room = rooms.get(j);
				
				if (room.size() >= M) continue;
				int baseLevel = room.get(0).level;
			    if (Math.abs(baseLevel - player.level) <= 10) {
			        room.add(player);
			        matched = true;
			        break;
			    }
			}
			
			if (!matched)  {
				ArrayList<Player> newroom = new ArrayList<>();
				newroom.add(player);
				rooms.add(newroom);
			}
			
		}
		
		for (int i = 0; i < rooms.size(); i++) {
			ArrayList<Player> room = rooms.get(i);
            room.sort(null);
			if (room.size() == M) {
				sb.append("Started!\n");
			} else {
				sb.append("Waiting!\n");
			}
			for (int j = 0; j < room.size(); j++) {
				sb.append(room.get(j).level + " " + room.get(j).name + "\n");
			}
		}
        System.out.println(sb);
	}

}
