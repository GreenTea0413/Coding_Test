class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = Integer.MAX_VALUE;
        int n = target.length;
        int m = target[0].length;
        
        int[][] diff = new int[n][m]; 
        
        // 뒤집어야 하는 칸들 고려
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                diff[i][j] = beginning[i][j] ^ target[i][j];
                
            }
        }
        
        
        // 행과 열을 만들어서 차이를 구하기
        for(int i = 0; i <= 1; i++){
            int[] row = new int[n];
            int[] col = new int[m];
            
            // 행을 먼저 기준으로 하기 행을 안뒤집는다는 가정하에
            row[0] = i;
            
            // 열은 차이와 row를 뒤집냐 안뒤집냐를 ^로 구하기
            for(int y = 0; y < m; y++){
                col[y] = diff[0][y] ^ row[0];
            }
            
            
            for(int x = 1; x < n; x++){
                row[x] = diff[x][0] ^ col[0];
            }
            
            boolean possible =true;
            
            for(int a = 0; a < n; a++){
                if(possible){
                    for(int b = 0; b < m; b++){
                        if((row[a] ^ col[b]) != diff[a][b]){
                            possible = false;
                            break;
                        }
                    }
                }
            }
            
            if(!possible) continue;
            int count = 0;
            for(int r : row){count += r;}
            for(int c : col){count += c;}
            
            answer= Math.min(answer, count);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}