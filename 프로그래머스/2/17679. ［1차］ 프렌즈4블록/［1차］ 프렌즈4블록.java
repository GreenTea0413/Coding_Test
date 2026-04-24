class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for(int i = 0; i < m; i++){
            map[i] = board[i].toCharArray();
        }
        while(true){
            boolean[][] check = new boolean[m][n];
            int count = 0;

            // 사라질 블록 갯수 구하기
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    Character now = map[i][j];
                    if(now == ' ') continue;
    
                    if(now == map[i][j + 1] && now == map[i + 1][j] 
                    && now == map[i + 1][j + 1]){
                        check[i][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j] = true;
                        check[i + 1][j + 1] = true;
                    }
                }
            }
            
            // check 가 true인 애들 이제 다 없애버리기
            for (int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(check[i][j]){
                        map[i][j] = ' ';
                        count ++;
                    }
                }
            }
            
            
            // 그리고 이제 밑에서 부터 비어있으면 위에서 끌고 내려와야함
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