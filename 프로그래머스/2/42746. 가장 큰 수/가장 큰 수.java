import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        
        String[] str = new String[len];
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}