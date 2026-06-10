import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Long> map = new HashMap<>();
        int[][] ratio = {{1, 1}, {2, 3}, {2, 4}, {3, 2}, {3, 4}, {4, 2}, {4, 3}};
        
        for(int w : weights){
            for(int[] r : ratio){
                double siso = (double) w * r[0] / r[1];
                if(map.containsKey(siso)){answer += map.get(siso);}
            }
            if(map.containsKey((double) w)){map.put((double) w, map.get((double) w) + 1);}
            else{map.put((double) w, 1L);}
        }
        return answer;
    }
}