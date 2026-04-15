class Solution {
    public int solution(int sticker[]) {
        int len= sticker.length;
        if(len == 1) return sticker[0];
        
        int dp1 = dp(sticker, 0, len - 2);
        int dp2 = dp(sticker, 1, len - 1);

        return Math.max(dp1, dp2);
    }
    
    public int dp(int sticker[], int start, int end){
        if(start == end) return sticker[start];
        
        int len = end - start + 1;
        int[] dp = new int[len];
        
        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start + 1]);
        
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }
        
        return dp[len-1];
    }
}