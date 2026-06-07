import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(char n : number.toCharArray()){
            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < n){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            
            sb.append(n);
        }
        
        sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }
}