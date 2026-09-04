import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 2 3 4로 만들 수 있는 조합  1 : 1은 하나면 되고
        // 2,3 2,4 3,2 3,4 4,2 4,3 
        int[][] rate = {{1,1}, {2,3}, {2,4}, {3,2}, {3,4}, {4,2}, {4,3}};
        
        // 여기에 값을 넣어서 해당 값들 만들어서 넣고 같은게 있으면 answer추가
        Map<Double, Long> map = new HashMap<>();
        for(int w : weights){
            for(int[] r : rate){
                double cal = (double) w * r[0] / r[1];
                // 이게 이제 map에 있으면? 맵에서 가지고 있는 수 만큼 짝이 있다는거니까
                if(map.containsKey(cal)) answer += map.get(cal);
            }
            // 그러고 나서 비율 다 계산했으면 w 원래 값 넣어놓기
            // 있으면 get으로 부럴와서 추가해주고 아니면 그냥 put
            if(map.containsKey((double) w)) map.put((double) w, map.get((double) w) + 1);
            else map.put((double) w, 1L);
        }
        return answer;
    }
}