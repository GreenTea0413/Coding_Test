class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        long[][] right = new long[m][n];
        long[][] down = new long[m][n];
        
        right[0][0] = 1;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 애초에 막히면 못가는 경우 
                if(cityMap[i][j] == 1) continue;
                
                if(i > 0){
                    // 지금 바로 윗부분이 2라서 우회전이 안된다면 바로 내려가는 것 밖에 없음
                    if(cityMap[i - 1][j] == 2) down[i][j] = down[i - 1][j];
                    else down[i][j] = (down[i - 1][j] + right[i - 1][j]) % MOD;
                }
                if(j > 0){
                    if(cityMap[i][j - 1] == 2) right[i][j] = right[i][j - 1];
                    else right[i][j] = (right[i][j - 1] + down[i][j - 1]) % MOD;
                }
            }
        }
        
        return (int) (right[m - 1][n - 1] + down[m - 1][n - 1]) % MOD;
    }
}