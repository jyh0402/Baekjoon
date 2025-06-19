import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int min = 1;
        int max = 100000;
        
        answer = max;
        
        while (min <= max) {
            int mid = (min+max)/2;
            long time = 0;
            int pos = 0;
            for (int i = 0; i < diffs.length ; i++) {
                if (time > limit) break;
                if (diffs[pos] <= mid) {
                    time += times[pos];
                    pos++;
                } else {
                    long sum = (times[pos] + times[pos-1]) * (diffs[pos] - mid);
                    time += times[pos] + sum;
                    pos++;
                }
            }

            boolean check = (time <= limit);
            if (check) { //된다
                answer = mid;
                max = mid - 1;                
            } else { //안된다
                min = mid + 1;
            }
        }
        
        return answer;
    }
}