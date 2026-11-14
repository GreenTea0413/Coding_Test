import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int len = players.length;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(players[i], i);    
        }
        
        for(String c : callings){
            int value = map.get(c);
            String temp = players[value - 1]; //poe
            players[value - 1] = c;
            players[value] = temp;
            
            map.put(c, value - 1);
            map.put(temp, value);
        }
        
        return players;
    }
}