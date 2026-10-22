class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int xLen = board.length;
        int yLen = board[0].length;
        
        int[][] dp = new int[xLen + 1][yLen + 1];
        for(int[] sk : skill){
            int type = sk[0]; int r1 = sk[1]; int c1 = sk[2];
            int r2 = sk[3]; int c2 = sk[4]; int degree = sk[5];
            // (r1, c1) (r2, c2)
            if(type == 1){
                dp[r1][c1] -= degree;
                dp[r1][c2 + 1] += degree;
                dp[r2 + 1][c1] += degree;
                dp[r2 + 1][c2 + 1] -= degree;
            }
            else{
                dp[r1][c1] += degree;
                dp[r1][c2 + 1] -= degree;
                dp[r2 + 1][c1] -= degree;
                dp[r2 + 1][c2 + 1] += degree;
            }
        }
        // 지금 누적합으로 구해야함
        // 가로 -> 오른쪽으로 이동하면서 값 더해주기
        // 0,0 = 0,1
        for(int i = 0; i < xLen; i++){
            for(int j = 1; j < yLen + 1; j++){
                dp[i][j] += dp[i][j - 1];
            }
        }
        
        // 그 다음 가로에서 더하기
        for(int i = 0; i < yLen; i++){
            for(int j = 1; j < xLen + 1; j++){
                dp[j][i] += dp[j - 1][i];
            }
        }
        
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(dp[i][j] + board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}