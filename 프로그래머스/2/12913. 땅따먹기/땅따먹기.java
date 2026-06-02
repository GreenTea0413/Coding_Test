class Solution {
    int answer = 0;
    int solution(int[][] land) {
        int len = land.length;
        int[][] dp = new int[len][4];
        
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j < 4; j++){
                dp[i][j] = Math.max(land[i][j] + 
Math.max(
    Math.max(dp[i-1][(j + 1)% 4], dp[i-1][(j + 2)% 4]), 
            dp[i-1][(j + 3)% 4]), 
            dp[i][j]);
            }
        }
    
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[len-1][i]);
        }
        return answer;
    }
}