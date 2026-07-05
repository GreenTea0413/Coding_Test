class Solution {
    public int solution(int n, int[] tops) {
        int MOD = 10007;

        // dp[i][0] = 오른쪽으로 마름모가 삐져나간 경우
        // dp[i][1] = 삐져나가지 않은 경우
        int[][] dp = new int[n][2];

        // 초기값 (i=0)
        if (tops[0] == 1) {
            dp[0][1] = 3;  // 삼각형만 / 왼쪽마름모 / 위쪽마름모
            dp[0][0] = 1;  // 오른쪽 삐져나가는 마름모
        } else {
            dp[0][1] = 2;  // 삼각형만 / 왼쪽마름모
            dp[0][0] = 1;  // 오른쪽 삐져나가는 마름모
        }

        for (int i = 1; i < n; i++) {
            int t = tops[i];

            if (t == 1) {
                dp[i][1] = (dp[i-1][1] * 3 + dp[i-1][0] * 2) % MOD;
                dp[i][0] = (dp[i-1][1] * 1 + dp[i-1][0] * 1) % MOD;
            } else {
                dp[i][1] = (dp[i-1][1] * 2 + dp[i-1][0] * 1) % MOD;
                dp[i][0] = (dp[i-1][1] * 1 + dp[i-1][0] * 1) % MOD;
            }
        }

        return (dp[n-1][0] + dp[n-1][1]) % MOD;
    }
}