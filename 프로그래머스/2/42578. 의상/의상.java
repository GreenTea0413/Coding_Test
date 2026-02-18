import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] c :  clothes){
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int count = 1;
        for (int v : map.values()){
            count *= (v + 1);
        }
        
        return count - 1;
    }
}