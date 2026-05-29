import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        
        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();
        
        a.put(topping[0], 1);
        for(int i = 1; i < len; i++){
            b.put(topping[i], b.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 1; i < len - 1; i++){
            a.put(topping[i], a.getOrDefault(topping[i], 0) + 1);
            b.put(topping[i], b.get(topping[i]) - 1);
            
            if(b.get(topping[i]) == 0) b.remove(topping[i]);
            if(a.size() == b.size()) answer ++;
        }
        return answer;
    }
}