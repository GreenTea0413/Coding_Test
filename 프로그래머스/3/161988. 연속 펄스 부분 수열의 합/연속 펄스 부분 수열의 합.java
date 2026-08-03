class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        long[][] dp = new long[len][2];
        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0] * -1;
        
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(sequence[i] * (i % 2 == 0 ? 1 : - 1), 
                                dp[i - 1][0] + sequence[i] * (i % 2 == 0 ? 1 : - 1));
            dp[i][1] = Math.max(sequence[i] * (i % 2 == 0 ? -1 : 1), 
                                dp[i - 1][1] + sequence[i] * (i % 2 == 0 ? -1 : 1));
        }
        
        for(int i = 0; i < len; i++){
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        
        return answer;
    }
}