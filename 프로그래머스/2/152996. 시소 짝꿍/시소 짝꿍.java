import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Long> map = new HashMap<>();
        
        double[][] ratios = {{1,1}, {2,3}, {3,2}, {1,2}, {2,1}, {3,4}, {4,3}};
        
        for (int w : weights) {
            for (double[] r : ratios) {
                double target = w * r[0] / r[1];
                if (map.containsKey(target)) {
                    answer += map.get(target);  
                }
            }
            if (map.containsKey((double) w)) {
                map.put((double) w, map.get((double) w) + 1);  
            } else {
                map.put((double) w, 1L);  
            }
        }
        
        return answer;
    }
}