class Solution {
    int MOD = 20170805; 
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        // 0, 0 -> m - 1, n - 1
        // 오른쪽 또는 아래로만 이동 가능  -> for문 반복하는거랑 사실상 동일함
        long[][] down = new long[m][n];
        long[][] right = new long[m][n];
        down[0][0] = 1;
        
        // 0,0에서 출발하는데 오른쪽으로 먼저 간다고 했을 때 1을만나면 바로 다음으로 넘어가기
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(cityMap[i][j] == 1) continue;
                
                // i가 0 보다 크면 제일 상단 벽에 붙어있는 거시 아니니까
                // 오른쪽에서도 올 수 있고 아래에서도 올 수 있음
                if(i > 0){
                    // 근데 만약에 여기서 현 위치의 바로 위의 값이 2여서 회전을 못한다?
                    // 그러면 어짜피 바로 위에서 내려오는거 밖에 안됨
                    // 아니면 현재 위치값은 두 배열의 값을 더해줘야함
                    if(cityMap[i - 1][j] == 2){down[i][j] = down[i - 1][j];}
                    else{down[i][j] = (down[i - 1][j] + right[i - 1][j]) % MOD;}
                }
                
                if(j > 0){
                    if(cityMap[i][j-1] == 2){right[i][j] = right[i][j-1];}
                    else{right[i][j] = (down[i][j-1] + right[i][j-1]) % MOD;}
                }
            }
        }
        
        
        return (int)(down[m - 1][n - 1] + right[m - 1][n - 1]) % MOD;
    }
}