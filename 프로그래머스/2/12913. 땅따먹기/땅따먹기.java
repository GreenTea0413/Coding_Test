class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        int[][] dp = new int[len][4];
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        // [1][0] 이면 [0][1], [0][2], [0][3] 중에서 고르기
        // [1][1] 이면 [0][0], [0][2], [0][3]
        for(int i = 1; i < len; i++){
            for(int j = 0; j < 4; j++){
                dp[i][j] = Math.max(land[i][j] + Math.max(Math.max(dp[i-1][(j + 1)% 4], dp[i-1][(j + 2)% 4]), dp[i-1][(j + 3)% 4]), dp[i][j]);    
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.max(dp[len-1][i], answer);
        }
        return answer;
    }
}