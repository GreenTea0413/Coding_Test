import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] str = new String[len];
        
        for(int i = 0; i < len; i++) str[i] = String.valueOf(numbers[i]);
        Arrays.sort(str, (a, b) -> ((b + a).compareTo(a + b)));
        
        for(int i = 0; i < len; i++) answer += str[i];
        if(answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}