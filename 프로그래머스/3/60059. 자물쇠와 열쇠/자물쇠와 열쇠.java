class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int[][] board = new int[3 * N][3 * N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i + N][j + N] = lock[i][j];
            }
        }
        
        for(int i = 0; i < 4; i++){
            key = rotate(key);
            
            for(int x = 0; x < 2 * N; x++){
                for(int y = 0; y < 2 * N; y++){
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            board[a + x][b + y] += key[a][b];
                        }
                    }
                    
                    if(check(board, N)){return true;}
                    
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            board[a + x][b + y] -= key[a][b];
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean check(int[][] board, int N){
        for(int i = N; i < 2 * N; i++){
            for(int j = N; j < 2 * N; j++){
                if(board[i][j] != 1) return false;
            }
        }
        return true;
    }
    
    public int[][] rotate(int[][] key){
        int n = key.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                // 0,0 -> 0,2
                // 1,1 -> 1,1
                // 1,2 -> 2,1
                result[j][n - i - 1] = key[i][j];
            }
        }
        return result;
    }
}