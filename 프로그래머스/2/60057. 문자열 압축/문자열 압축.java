import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, compress(s, i));
        }

        return answer;
    }
    
    int compress(String s, int len){
        List<String> words = new ArrayList<>();
        for(int i = 0; i < s.length(); i += len){
            words.add(s.substring(i, Math.min(s.length(), i + len)));
        }
        
        StringBuilder sb = new StringBuilder();
        String pre = "";
        int count = 0;
        
        for(String word : words){
            if(word.equals(pre)){
                count++;
            }
            else{
                if(count > 1){
                    sb.append(String.valueOf(count));
                }
                sb.append(pre);
                pre = word;
                count = 1;
            }
        }
        if(count > 1){
            sb.append(String.valueOf(count));
        }
        sb.append(pre);
        
        return sb.toString().length();
    }
}