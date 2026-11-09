import java.util.*;

public class Solution {
    public int solution(int n) {
        // 처음에는 어차피 무조건 1 가야함
        int answer = 0;
        while(n > 0){
            if(n % 2 == 0) n /= 2;
            else {
                n --;
                answer++;
            }
        }
//         int[] dp = new int[n + 1];
        
//         dp[0] = 0;
//         dp[1] = 1;
        
//         for(int i = 2; i <= n; i++){
//             if(i % 2 == 0) dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2]);
//             else dp[i] = dp[i - 1] + 1;
//         }
        
        return answer;
    }
}