class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int[][] lock3 = new int[n * 3][n * 3];
        
        for(int i = n; i < n * 2; i++){
            for(int j = n; j < n * 2; j++){
                lock3[i][j] = lock[i - n][j - n];
            }
        }
        
        int m = key.length;
        // 시작점으로부터 이제 4방향으로 돌리면서 키가 다 맞는지 확인
        for(int i = 0; i < 4; i++){
            key = rotate(key);
            for(int x = 0; x < n * 2; x++){
                for(int y = 0 ; y < n * 2; y++){
                    // 여기서 이제 x,y 기준으로 열쇠 크기에 맞게 값 넣기
                    for(int a = 0; a < m; a++){
                        for(int b = 0; b < m; b++){
                            lock3[x + a][y + b] += key[a][b];
                        }
                    }
                    
                    if(check(lock3, n)) return true;
                    
                    for(int a = 0; a < m; a++){
                        for(int b = 0; b < m; b++){
                            lock3[x + a][y + b] -= key[a][b];
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public int[][] rotate(int[][] key){
        int n = key.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = key[n - j - 1][i];
            }
        }
        return result;
    }
    
    public boolean check(int[][] map, int n){
        for(int i = n; i < n * 2; i++){
            for(int j = n; j < n * 2; j++){
                if(map[i][j] != 1) return false;
            }
        }
        return true;
    }
}