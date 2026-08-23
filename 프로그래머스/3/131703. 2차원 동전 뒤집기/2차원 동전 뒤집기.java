class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = Integer.MAX_VALUE;
        
        // 하나 뒤집으면 한번에 그 줄 전체를 뒤집는거임
        // 1,0을 선택했고 가로로 하겠다고 했으면 ------ 이렇게다 돌리는거임
        int n = target.length;
        int m = target[0].length;
        int[][] arr = new int[n][m];
        
        // 값이 서로 다른지를 파악해야함
        // XOR로 값이 다른 위치에 1을 대입 같으면 0
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = beginning[i][j] ^ target[i][j];
            }
        }
        
        // 처음 위치에 0 과 1 둘 중 값을 넣어서 뒤집을 행과 열을 구하기
        for(int i = 0; i <= 1; i++){
            int[] row = new int[n];
            int[] col = new int[m];
            
            row[0] = i;
            
            // row[0] = 0일 때 첫가로줄은 안 뒤집는거니까 거기에 맞게 col도 뒤집어야하는지 구하기
            for(int j = 0; j < m; j++){
                col[j] = arr[0][j] ^ row[0];
            }
            
            for(int k = 0; k < n; k++){
                row[k] = arr[k][0] ^ col[0];
            }
            
            boolean possible = true;
            
            for(int a = 0; a < n; a++){
                if(possible){
                    // 아직까지 가능하다면 돌려야한다...
                    for(int b = 0; b < m; b++){
                        // 그리고 row랑 col을 돌리지 말지에 대해서 arr랑 같이 다르면 땡
                        if((row[a] ^ col[b]) != arr[a][b]){
                            possible = false;
                            break;
                        }
                    }
                }
            }
            if(!possible) continue;
            int count = 0;
            for(int r : row) count += r;
            for(int c : col) count += c;
            
            answer = Math.min(answer, count);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}