import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] v = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                
                if(cur.equals(target)) return answer;
                
                for(int j = 0; j < words.length; j++){
                    if(!v[j] && isDiff(cur, words[j]) == 1){
                        v[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
            answer ++;
        }
        return 0;
    }
    
    public int isDiff(String s1, String s2){
        int gap = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) gap++;
        }
        
        return gap;
    }
}