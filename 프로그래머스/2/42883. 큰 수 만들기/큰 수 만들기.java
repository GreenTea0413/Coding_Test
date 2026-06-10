import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : number.toCharArray()){
            while(sb.length() > 0 && k >0 && sb.charAt(sb.length() - 1) < c){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        
        sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }
}