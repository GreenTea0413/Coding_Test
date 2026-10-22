import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int[] answer = new int[2];
        String prev = words[0];
        set.add(prev);
        
        for(int i = 1; i < words.length; i++){
            if(set.contains(words[i])) return new int[]{i % n + 1, (i / n) + 1};
            
            if(prev.charAt(prev.length() - 1) == words[i].charAt(0)){
                set.add(words[i]);
                prev = words[i];
            }
            else return new int[]{i % n + 1, (i / n) + 1};
        }

        // 여기까지 탈락자가 생기지 않는다면 [0, 0]
        return answer;
    }
}