import java.util.*;

class Solution {
    static int[] animals;
    static int[][] tree = new int[21][2];
    static int answer;
    public int solution(int[] info, int[][] edges) {
        animals = info;
        for (int i = 0 ; i < 21; i++){
            tree[i][0] = -1;
            tree[i][1] = -1;
        }
        for (int i = 0; i<edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            if (tree[parent][0] == -1) tree[parent][0] = child;
            else tree[parent][1] = child;
        }
        HashSet<Integer> list = new HashSet<>();
        list.add(0);
        search(1,0,list);
        
        return answer;
    }
    
    public static void search(int sc, int wc, Set<Integer> lst) {
        if (sc <= wc) return;
        answer = Math.max(answer,sc);
        for (int cur : lst) {
            if (tree[cur][0] != -1 && !lst.contains(tree[cur][0])) {
                HashSet<Integer> set = new HashSet<>(lst);
                set.add(tree[cur][0]);
                if (animals[tree[cur][0]] == 0) {
                    search(sc+1,wc,set);
                }
                else search(sc,wc+1,set);
            }
            
            if (tree[cur][1] != -1 && !lst.contains(tree[cur][1])) {
                HashSet<Integer> set = new HashSet<>(lst);
                set.add(tree[cur][1]);
                if (animals[tree[cur][1]] == 0) {
                    search(sc+1,wc,set);
                }
                else search(sc,wc+1,set);
            }
        }
    }
}