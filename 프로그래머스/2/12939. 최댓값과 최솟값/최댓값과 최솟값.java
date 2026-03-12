import java.util.*;
class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = - Integer.MAX_VALUE;
        
        String[] arr = s.split(" ");
        
        for(int i = 0; i < arr.length; i++){
            int n = Integer.parseInt(arr[i]);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        String answer = min + " " + max;
        return answer;
    }
}