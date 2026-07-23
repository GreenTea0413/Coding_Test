import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        int len = s.length;
        String[] answer = new String[len];
        
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder();
            String str = s[i];
            int count = 0;
            
            for(char c : str.toCharArray()){
                sb.append(c);
                
                if(sb.length() >= 3){
                    char c1 = sb.charAt(sb.length() - 3);
                    char c2 = sb.charAt(sb.length() - 2);
                    char c3 = sb.charAt(sb.length() - 1);
                    
                    if(c1 == '1' && c2 == '1' && c3 == '0'){
                        count++;
                        sb.setLength(sb.length() - 3);
                    }
                }
            }
            
            StringBuilder result = new StringBuilder();
            int lastIdx = sb.lastIndexOf("0");
            
            if(lastIdx == -1){
                for(int j = 0; j < count; j++){
                    result.append("110");    
                }
                result.append(sb);
            }
            else{
                result.append(sb.substring(0,lastIdx + 1));
                for(int j = 0; j < count; j++){
                    result.append("110");
                }
                result.append(sb.substring(lastIdx + 1));
            }
            answer[i] = result.toString();
        }
        return answer;
    }
}