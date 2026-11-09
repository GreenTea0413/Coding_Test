class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        
        int[] dp = new int[len];
        // 처음 값 넣어주기 4 5 2 6 5
        for(int i = 0; i < len; i++) dp[i] = triangle[len - 1][i];
        
        // 이제 0 1 2 3 4 층 중에서 4층걸 다 넣어놨으니 나머지계산
        for(int i = len - 2; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                dp[j] = Math.max(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }
}