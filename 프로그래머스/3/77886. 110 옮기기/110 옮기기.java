import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        int len = s.length;
        String[] answer = new String[len];
        
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            String str = s[i];
            
            for(char c : str.toCharArray()){
                sb.append(c);
                
                if(sb.length() >= 3 && 
                    sb.charAt(sb.length() - 3) == '1' && 
                    sb.charAt(sb.length() - 2) == '1' && 
                    sb.charAt(sb.length() - 1) =='0'){
                    sb.setLength(sb.length() - 3);
                    count++;
                }
            }
            
            StringBuilder result = new StringBuilder();
            int lastIdx = sb.lastIndexOf("0");
            
            if(lastIdx == -1){
                for(int j = 0; j < count; j++){
                    result.append("110");
                }
                result.append(sb.toString());
            }
            else{
                result.append(sb.substring(0, lastIdx + 1));
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