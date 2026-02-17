import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion){
            map.put(c, map.get(c) - 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            
            if (val == 1){
                answer = key;
            }
        }
        
        
        return answer;
    }
}