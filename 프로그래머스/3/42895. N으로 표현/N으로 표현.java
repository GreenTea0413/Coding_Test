import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number){
            return 1;
        }
        // dp[1] = 5
        // dp[2] = 5 + 5, 5 * 5, 5 - 5, 5 / 5, 55
        // dp[3] = 5 + 55, 5 * 55, 5 / 55
        // dp[3] = dp[1] + dp[2] or dp[2] + dp[1]
        // dp[i] = dp[i-j] + dp[j] 
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++){
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(num);
            
            for (int j = 1; j < i; j++){
                for(int n1 : dp.get(j)){
                    for (int n2 : dp.get(i-j)){
                        dp.get(i).add(n1 + n2);
                        dp.get(i).add(n1 - n2);
                        dp.get(i).add(n1 * n2);
                        if (n2 != 0){
                            dp.get(i).add(n1 / n2);
                        }
                    }
                }
            }
            if (dp.get(i).contains(number))
                return i;
        }
        return -1;
    }
}