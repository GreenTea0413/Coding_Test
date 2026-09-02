import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        
        String[] arr = new String[len];
        for(int i = 0; i < len; i++) arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, (a, b) -> ((b + a).compareTo(a + b)));
        
        for(String s : arr) answer += s;
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}