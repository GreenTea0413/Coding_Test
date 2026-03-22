import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        left.put(topping[0], 1);
        for(int i = 1; i < len; i ++){
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 1; i < len-1; i++){
            left.put(topping[i], left.getOrDefault(topping[i] ,0) + 1);
            right.put(topping[i], right.get(topping[i]) - 1);
            
            if(right.get(topping[i]) == 0) right.remove(topping[i]);
            if(left.size() == right.size()) answer += 1;
        }
        return answer;
    }
}