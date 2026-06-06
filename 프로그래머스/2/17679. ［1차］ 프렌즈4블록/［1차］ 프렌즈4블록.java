class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for(int i = 0; i < m; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(true){
            boolean [][] v = new boolean[m][n];
            int count = 0;
            
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    char now = map[i][j];
                    if(now == ' ') continue;
                    
                    if(now == map[i + 1][j] && now == map[i][j+1] && now == map[i+1][j+1]){
                        v[i][j] = true;
                        v[i][j + 1] = true;
                        v[i + 1][j] = true;
                        v[i + 1][j + 1] = true;
                    }
                }
            }
            
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(v[i][j]){
                        map[i][j] = ' ';
                        count++;
                    }
                }
            }
            
            for(int j = 0; j < n; j++){
                for(int i = m - 1; i >= 0; i--){
                    if(map[i][j] == ' '){
                        for(int k = i - 1; k >= 0; k--){
                            if(map[k][j] != ' '){
                                map[i][j] = map[k][j];
                                map[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
            
            if(count == 0) break;
            answer += count;
        }
        
        
        return answer;
    }
}