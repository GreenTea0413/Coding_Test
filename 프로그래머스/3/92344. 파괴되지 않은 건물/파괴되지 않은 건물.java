class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] map = new int[n + 1][m + 1];
        
        // 이거 전에 무슨 점 끝 부분만 계산하기
        // 1,0,0,3,4,4면 1은 공격 0,0 ~ 3,4 까지 4만큼 감소
        // 각 점을 따지면 (0,0) (0,4) (3,0) (3,4)
        // 누적합으로 이 문제를 풀어야 시간초과가 발생안함
        
        for(int[] s : skill){
            if(s[0] == 1){
                map[s[1]][s[2]] -= s[5];
                map[s[1]][s[4] + 1] += s[5];
                map[s[3] + 1][s[2]] += s[5];
                map[s[3] + 1][s[4] + 1] -= s[5];
            }
            else{
                map[s[1]][s[2]] += s[5];
                map[s[1]][s[4] + 1] -= s[5];
                map[s[3] + 1][s[2]] -= s[5];
                map[s[3] + 1][s[4] + 1] += s[5];
            }
        }
        
        // 0 0 0 0 0 0
        // 0 0 0 0 0 0
        // 0 0 0 0 0 0
        // 0 0 0 0 0 0
        // 0 0 0 0 0 0
        
        // -4 0 0 0 0 4
        // 0 0 0 0 0 0
        // 0 0 0 0 0 0
        // 0 0 0 0 0 0
        // 4 0 0 0 0 -4
        
        // 왼쪽 부터 오른쪽으로 가면서 값 더해주기
        for(int i = 0; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                map[i][j] += map[i][j - 1];   
            }
        }
        
        // 위에서 아래로 값 더해주기
        for(int i = 0; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                map[j][i] += map[j - 1][i];   
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] + map[i][j] > 0)  answer++;
            }
        }
        return answer;
    }
}