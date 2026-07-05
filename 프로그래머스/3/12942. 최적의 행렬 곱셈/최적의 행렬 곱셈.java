class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n];

        // 구간 길이를 2부터 n까지 늘려가며 계산
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // 쪼개는 지점 k를 i부터 j-1까지 시도
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                             + matrix_sizes[i][0]      // 왼쪽 묶음의 행
                             * matrix_sizes[k][1]       // 왼쪽 묶음의 열 = 오른쪽 묶음의 행
                             * matrix_sizes[j][1];      // 오른쪽 묶음의 열
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}