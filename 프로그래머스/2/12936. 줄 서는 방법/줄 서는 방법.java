import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){factorial[i] = factorial[i - 1] * i;}
        
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) nums.add(i);
        
        k--;
        
        for(int i = n; i >= 1; i--){
            long fact = factorial[i-1];
            int idx = (int) (k / fact);
            answer[n-i] = nums.get(idx);
            nums.remove(idx);
            k %= fact;
        }
        
        return answer;
    }
}