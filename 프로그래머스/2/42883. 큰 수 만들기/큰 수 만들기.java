import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : number.toCharArray()){
            // 문자열 순서대로 꺼내면서 sb의 마지막 끝자락이 지금보다 작으면 빼야함
            while(sb.length() > 0 &&  k > 0 && sb.charAt(sb.length() - 1) < c){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            // 그 다음에 더해주기
            // 그러면 1 -> 19 -> 192 -> 194가 됨
            sb.append(c);
        }
        
        
        // 194에서는 그럼 어떻게 하냐. 뒤에 숫자를 그만큼 짤라야함
        // 왜냐면 어차피 194뒤에 2 1이 들어와야 19421처럼 되는거지 19456은 안됨
        // k가 존재한다면 뒤에 숫자가 큰게 그냥 쌓일리가 없기 떄문
        sb.delete(sb.length() - k, sb.length());
        
        return sb.toString();
    }
}