class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        // 누적합으로 푸는 문제
        int n = board.length;
        int m = board[0].length;
        
        // dp에는 skill로 인해서 부숴지거나 세우는거에 범위를 넣기
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] s : skill){
            int type = s[0]; 
            int r1 = s[1]; 
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            // 0,0 ~ 3,4 까지를 정한다면
            // 4,0에는 -degree를 넣어야함
            // 0,0 1,0 2,0 3,0 4,0에서
            // -4 0 0 0 4 // -4 -4 -4 -4  0 // -4 -4 -4 -4 0
            // 0 0 0 0 0  // -4  0  0  0  0 // -4 -4 -4 -4 0
            // 0 0 0 0 0  // -4  0  0  0  0 // -4 -4 -4 -4 0
            // 4 0 0 0 -4 //  0  0  0  0 -4 //  0  0  0  0 0
            if(type == 1){
                dp[r1][c1] -= degree;
                dp[r1][c2 + 1] += degree;
                dp[r2 + 1][c1] += degree;
                dp[r2 + 1][c2 + 1] -= degree;
            }
            else{
                dp[r1][c1] += degree;
                dp[r1][c2 + 1] -= degree;
                dp[r2 + 1][c1]  -= degree;
                dp[r2 + 1][c2 + 1] += degree;
            }
        }
        
        // 누적합 범위 정했으니 이제 더하기하면서 값 정하기
        // 왼쪽값을 오른쪽으로 넣기
        for(int i = 0; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                dp[i][j] += dp[i][j-1];
            }
        }
        
        // 위에서 아래로 값 넣기
        for(int i = 0; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                dp[j][i] += dp[j - 1][i];
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] + dp[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}