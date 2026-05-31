import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for(int i = 0; i < str1.length() - 1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            
            if(c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z'){
                String temp = "" + c1 + c2;
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            
            if(c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z'){
                String temp = "" + c1 + c2;
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
        }
        
        
        int sub = 0;
        int total = 0;
        
        for(String key : map1.keySet()){
            if(map2.containsKey(key)) {
                sub += Math.min(map1.get(key), map2.get(key));
            }
        }
        
        Set<String> all = new HashSet<>();
        all.addAll(map1.keySet());
        all.addAll(map2.keySet());
        
        
        for(String key : all){
            int val1 = map1.getOrDefault(key, 0);
            int val2 = map2.getOrDefault(key, 0);
            
            total += Math.max(val1, val2);
        }
        
        return total == 0 ? 65536 : (int)(((double) sub / total) * 65536);
    }
}