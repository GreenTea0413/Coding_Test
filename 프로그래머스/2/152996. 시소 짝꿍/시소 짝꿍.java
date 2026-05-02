import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Long> map = new HashMap<>();
        
        double[][] ratio = {{1,1}, {2,3}, {1,2}, {3,2}, {3,4}, {2,1}, {4,3}};
        
        for(int w : weights){
            // 그 다음 w를 또 꺼내서 비율 만큼 곱해서 값이 있는지 확인 있으면 answer에 그 만큼 더해주기
            for(double[] r : ratio){
                double temp = (double) w * (r[0] / r[1]);
                if(map.containsKey(temp)) {answer += map.get(temp);}
            }
            // map에 있으면 있는 값에다가 + 1
            // 없으면 새로 put 1개 있다고 해주기
            if(map.containsKey((double) w)){ map.put((double) w, map.get((double) w) + 1);}
            else{map.put((double) w, 1L);}
        }
        
        return answer;
    }
}