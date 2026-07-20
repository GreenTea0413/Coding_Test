class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int N = lock.length;
        int M = key.length;
        int[][] board = new int[3 * N][3 * N];
        
        // 자물쇠를 9*9의 한 가운데 3*3 배열에 맞춰넣기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i + N][j + N] = lock[i][j];
            }
        }
        
        // 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0
        // 0 0 0 1 1 1 0 0 0
        // 0 0 0 1 1 0 0 0 0
        // 0 0 0 1 0 1 0 0 0
        // 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0
        
        // 이제 부분씩 잘라서 key를 넣어볼 거임
        // key의 크기에 따라서 모든 값을 넣어보았을 때 저기 한 가운데 lock이 모두 1이면 열림
        // 아닐 경우에는 더한 값 다시 뺀 다음에 비교하기
        for(int i = 0; i < 4; i++){
            key = rotate(key);
            
            for(int x = 0; x < 2 * N; x++){
                for(int y = 0; y < 2 * N; y++){
                    // 0,0 ~ 5,5까지 해서 해당 되는 key 범위들을 다 더해볼거임
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            board[x + a][y + b] += key[a][b];
                        }
                    }
                    
                    if(check(board, N)){return true;}
                    
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            board[x + a][y + b] -= key[a][b];
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean check(int[][] b, int N){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(b[i + N][j + N] != 1) return false;
            }
        }
        return true;
    }
    
    public int[][] rotate(int[][] key){
        int M = key.length;
        int[][] result = new int[M][M];
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                result[i][j] = key[M - j - 1][i];
            }
        }
        
        return result;
    }
}