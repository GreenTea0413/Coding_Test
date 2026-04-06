import java.util.*;
class Solution {
    int answer;
    public int solution(String begin, String target, String[] words) {
        boolean[] v = new boolean[words.length];
        answer = words.length;
        dfs(begin, target, words, v, 0);
        
        if (answer == words.length) return 0;
        return answer;
    }
    // dfs + 백트래킹으로 모든 단어 돌면서 찾아보기
    public void dfs(String begin, String target, String[] words, boolean[] v, int count){
        if(begin.equals(target)){
            answer = Math.min(count, answer);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            int c = 0;
            String word = words[i];
            for (int j = 0; j < word.length(); j++){
                if (begin.charAt(j) != word.charAt(j)){ c+= 1;}
            }
            
            if(c == 1 && !v[i]){
                v[i] = true;
                dfs(word, target, words, v, count + 1);
                v[i] = false;
            }
        }
    }
}