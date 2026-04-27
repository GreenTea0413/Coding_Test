import java.util.*;
class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        // 문자열 길이 만큼 단위를 쪼개기
        for(int i = 1; i <= len; i++){
            // 처음 1개 단위
            StringBuilder sb = new StringBuilder();
            // 단어 처음 것을 먼저 기준 잡음
            // "ababcdcdababcdcd"
            // unit = a next = b
            String unit = s.substring(0, i);
            int start =i, end = i * 2;
            int count = 1;
            
            while(end <= len){
                String next = s.substring(start, end);
                // a b가 다르면 a를 그냥 넣음
                if(!unit.equals(next)){
                    if(count > 1) sb.append(count);
                    sb.append(unit);
                    unit = next;
                    count = 1;
                }
                // a a가 같으면
                else{
                    count += 1;
                }
                
                start += i;
                end += i;
            }
            if(count > 1){sb.append(count);}
            sb.append(unit);
            
            if(end >= len) sb.append(s.substring(start));
            answer = Math.min(sb.length(), answer);
        }
        return answer;
    }
}