import java.util.*;

class Solution {
    static int answer = 51;
    static boolean[] v;
    public void dfs(String s, String end, String[] words, int count){
        if(s.equals(end)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            String t = "";
            int num = 0;
            String w = words[i];
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) != w.charAt(j)){
                    t += w.charAt(j);
                    num++;
                }
                else{
                    t += s.charAt(j);
                }
            }
            if(num == 1 && !v[i]){
                v[i] = true;
                dfs(t, end, words, count + 1);
                v[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        v= new boolean[words.length];
        
        dfs(begin, target, words, 0);
        if(answer == 51) answer = 0;
        return answer;
    }
}