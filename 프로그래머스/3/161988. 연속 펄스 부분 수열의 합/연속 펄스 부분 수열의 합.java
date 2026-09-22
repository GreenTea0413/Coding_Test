class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        long[][] dp = new long[len][2];
        // 하나는 +1 부터 곱하기
        // 하나는 -1 부터 곱하기로 구분
        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0] * -1;
        
        // 0 기준으로 가면 다음 3은 * -1 / -6은 * 1 이렇게 이어가야함
        // 그래서 다음 sequence에서 현재 값에다가 다음 -1또는 1을 곱했을 때의 값
        // 아니면 dp[i - 1][0]의 값과 sequence[i] * -1 또는 1을 곱했을 때의 값
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(sequence[i] * ((i % 2 == 0) ? 1 : -1), 
                                dp[i - 1][0] + sequence[i] * ((i % 2 == 0) ? 1 : -1));
                
            dp[i][1] = Math.max(sequence[i] * ((i % 2 == 0) ? -1 : 1), 
                                dp[i - 1][1] + sequence[i] * ((i % 2 == 0) ? -1 : 1));
        }
        
        for(int i = 0; i < len; i++){
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        
        return answer;
    }
}