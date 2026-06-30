class Solution {
    int[][] d = {{0,1}, {1,0}};
    public int solution(int m, int n, int[][] cityMap) {
        int MOD = 20170805;
        
        long[][] down = new long[m][n];
        long[][] right = new long[m][n];
        down[0][0] = 0;
        right[0][0] = 1;
        
        //아래, 오른쪽 이동만 가능
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                // 1이면 x
                if(cityMap[x][y] == 1) continue;
                
                // 위에서 내려오는 경우 인데 방향 2면 위에서 내려오는거 밖에 안되니까  x - 1에서 더해주고
                // 아닌경우에는 down과 right 둘 다 가능
                if(x > 0){
                    if(cityMap[x - 1][y] == 2){down[x][y] = down[x - 1][y];}
                    else{down[x][y] = (down[x-1][y] + right[x-1][y]) % MOD;}
                }
                
                if(y > 0){
                    if(cityMap[x][y - 1] == 2){right[x][y] = right[x][y - 1];}
                    else{right[x][y] = (down[x][y - 1] + right[x][y - 1]) % MOD;}
                }
            }
        }
        
        return (int) ((down[m - 1][n - 1] + right[m - 1][n - 1]) % MOD);
    }
}