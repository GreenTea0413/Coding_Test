class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int[][] arr = new int[N * 3][N * 3];
        // 자물쇠를 3 * 3 -> 9*9로 만든다음에 가운데에 배치해서 열쇠 다 돌려보게끔하기
        for(int i = N; i < 2 * N; i++){
            for(int j = N; j < 2 * N; j++){
                arr[i][j] = lock[i - N][j - N];
            }
        }
        
        
        // 0,0 부터 시작하게 되면 거기서 부터 열쇠 크기 만큼 비교해서 0을 1로 바꿨을 때 열쇠가 다 1이라면?
        // 시작점에 대해서 이렇게 돌리면 되긴한데 열쇠 돌려가면서 대치하기
        for(int k = 0; k < 4; k++){
            // 90도 4번 돌릴거니까 4번하고
            key = rotate(key);

            for(int x = 0; x < 2 * N; x++){
                for(int y = 0; y < 2 * N; y++){
                    // 시작점을 기준으로 이제 M만큼 열쇠 값들 더하기
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            arr[x + a][y + b] += key[a][b];
                        }
                    }
                    
                    if(check(arr, N)) return true;
                    
                    // 그리고 약간 백트래킹 느낌으로 계산해준거 다 빼고 다음으로 넘어가기
                    for(int a = 0; a < M; a++){
                        for(int b = 0; b < M; b++){
                            arr[x + a][y + b] -= key[a][b];
                        }
                    }
                }
            }
        }
 
        return false;
    }
    
    boolean check (int[][] arr, int N){
        for(int i = N; i < 2 * N; i++){
            for(int j = N; j < 2 * N; j++){
                if(arr[i][j] != 1) return false;
            }
        }
        return true;
    }
    int[][] rotate(int[][] arr){
        int M = arr.length;
        int[][] temp = new int[M][M];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                temp[i][j] = arr[j][M - i - 1];
            }
        }
        
        return temp;
    }
}