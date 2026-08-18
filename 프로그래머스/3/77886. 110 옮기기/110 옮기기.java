import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        int len = s.length;
        String[] answer = new String[len];
        
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            
            for(char c : s[i].toCharArray()){
                sb.append(c);

                if(sb.length() >= 3){
                    if(sb.charAt(sb.length() - 1) == '0' &&
                        sb.charAt(sb.length() - 2) == '1' &&
                        sb.charAt(sb.length() - 3) == '1'){
                        count ++;
                        sb.setLength(sb.length() - 3);
                    }
                }
            }
            
            StringBuilder result = new StringBuilder();
            int lastIdx = sb.lastIndexOf("0");
            // 0이 있으면 0뒤로 110 붙여야함
            // 0이 없으면 젤 앞에 먼저 110 붙여야함
            if(lastIdx != -1){
                // 0이 아니면 result에 sb를먼저 붙이기 0 오기 전
                result.append(sb.substring(0, lastIdx + 1));
                for(int j = 0; j < count; j++) result.append("110");
                result.append(sb.substring(lastIdx + 1));
            }
            else{
                for(int j = 0; j < count; j++) result.append("110");
                result.append(sb);
            }
            
            answer[i] = result.toString();
        }
         
        return answer;
    }
}