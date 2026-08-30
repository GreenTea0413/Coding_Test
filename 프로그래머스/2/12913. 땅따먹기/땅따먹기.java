class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = 4;
        
        int[][] dp = new int[n][4];
        for(int i = 0; i < 4; i++) dp[0][i] = land[0][i];
        
        // 일단 dp에 각 위치 값을 넣어놓고
        // 다음 depth 부터는 해당 i 말고 다른 걸 더했을 때 최대값이 되는 것을 넣기
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 4; j++){
                // 1,0 -> 0,1, 0,2, 0,3 + land[1][0]이랑 비교해야함
                dp[i][j] = Math.max(Math.max(dp[i - 1][(j + 1) % 4], dp[i - 1][(j + 2) % 4]),dp[i - 1][(j + 3) % 4]) + land[i][j]; 
            }
        }

        for(int i = 0; i < 4; i++) answer= Math.max(answer, dp[n - 1][i]);
        return answer;
    }
}