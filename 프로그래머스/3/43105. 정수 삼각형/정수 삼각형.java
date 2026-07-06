class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        
        int[] dp = new int[len];
        for(int i = 0; i < len; i++){
            dp[i] = triangle[len-1][i];
        }
        // 4 5 2 6 5
        
        for(int depth = len - 2; depth >= 0; depth--){
            for(int i = 0; i < triangle[depth].length; i++){
                dp[i] = Math.max(dp[i], dp[i + 1]) + triangle[depth][i];
            }
        }
        return dp[0];
    }
}