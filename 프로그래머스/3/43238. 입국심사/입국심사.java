import java.util.*;

class Solution {
    public long solution(int n, int[] times) {        
        long left = 0;
        long right = 0;
        for(int t : times){
            right = Math.max(t, right);
        }
        right *= n;
        
        long answer = right;
        
        while(left <= right){
            long mid = (left + right) / 2;
        
            long total = 0;
            for(int t : times){
                total += mid / t;        
            }
            
            if (total >= n){
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}