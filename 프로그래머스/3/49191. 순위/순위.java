class Solution {
    public int solution(int n, int[][] results) {
        //   1 2 3 4 5
        // 1 x
        // 2   x
        // 3     x
        // 4       x
        // 5         x
        
        // 이런식으로 표를 만들어서 [A, B] 에서 A가 이겼다는 뜻이니까 [4,3]
        // arr[4][3] = true;
        //   1 2 3 4 5 -> A
        // 1 x o    
        // 2   x     o
        // 3   o x 
        // 4   o o x
        // 5         x
        
        int answer = 0;
        boolean[][] map = new boolean[n + 1][n + 1];
        for(int[] r : results){
            map[r[0]][r[1]] = true;
        }
        // 만약에 [4, 3] -> [3, 2] 뜻은 4 -> 2도 이겼다는 뜻
        // [1, 2] -> [2, 5] -> 1 -> 5도 이긴다는 뜻
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(map[i][k] && map[k][j]){
                        map[i][j] = true;
                    }
                }
            }
        }
        
        for(int i = 1; i<= n; i++){
            int count = 0;
            
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(map[i][j] || map[j][i]){
                    count ++;
                }
            }
            
            if(count == n - 1){answer ++;}
        }
        
        return answer;
    }
}