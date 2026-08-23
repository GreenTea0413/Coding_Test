class Solution {
    public int solution(int[][] matrix_sizes) {
        // dp로 푸는 문제! 행렬은 dp라고 생각하기 -> 계속해서 숫자값을 곱해서 이어가야하니까
        
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n];
        
        // 길이를 처음에 2개로 잡기
        // 그래야 행렬끼리 곱한거를 쌓아감
        for(int len = 2; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++){
                    int cost = dp[i][k] + dp[k + 1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * 
                        matrix_sizes[j][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][n - 1];
    }
}