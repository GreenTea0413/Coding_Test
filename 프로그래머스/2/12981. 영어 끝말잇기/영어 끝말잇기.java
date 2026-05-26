import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        String last = words[0];
        set.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            String w = words[i];
            if(set.contains(w) || (last.charAt(last.length() - 1) != w.charAt(0))){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                
                return answer;
            }
            last = w;
            set.add(w);
        }
        
        return answer;
    }
}