import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            answer *= (entry.getValue() + 1);
        }
        return answer - 1;
    }
}