import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = discount.length;
        
        for(int start = 0; start < len - 9; start++){
            Map<String, Integer> map = new HashMap<>();
            for(int i = start; i < start + 10; i++){
                map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            }
            
            boolean pass = true;
            for(int i = 0; i < want.length; i++){
                if(!map.containsKey(want[i])) {pass = false; break;}
                if(map.get(want[i]) != number[i]) {pass = false; break;}
            }
            if(pass) answer++;
        }
        return answer;
    }
}