class Solution {
    int MOD = 20170805;
    
    int[][] d = {{0,1}, {1,0}};
    public int solution(int m, int n, int[][] cityMap) {
        // 결국엔 오른쪽 아래로만 이동
        long[][] right = new long[m][n];
        long[][] down = new long[m][n];
        right[0][0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(cityMap[i][j] == 1) continue;
                
                if(i > 0){
                    if(cityMap[i - 1][j] == 2) down[i][j] = down[i - 1][j];
                    else down[i][j] = (right[i - 1][j] + down[i - 1][j]) % MOD;
                }
                
                if(j > 0){
                    if(cityMap[i][j - 1] == 2) right[i][j] = right[i][j - 1];
                    else right[i][j] = (down[i][j - 1] + right[i][j - 1]) % MOD;
                }
                
            }
        }
        
         return (int)(down[m - 1][n - 1] + right[m - 1][n - 1]) % MOD;
    }
}