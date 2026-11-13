import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> human = new HashMap<>();
        for(String p : participant){
            human.put(p, human.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion) {
            human.put(c, human.get(c) - 1);
            if(human.get(c) == 0) human.remove(c);
        }
        
        for(Map.Entry<String, Integer> entry : human.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }
        
        return answer;
    }
}