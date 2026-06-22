class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int x = board.length;
        int y = board[0].length;
        int[][] sum = new int[x + 1][y + 1];
        
        for(int i = 0; i < skill.length; i++){
            if(skill[i][0] == 1){
                sum[skill[i][1]][skill[i][2]] -= skill[i][5];
                sum[skill[i][1]][skill[i][4] + 1] += skill[i][5];
                sum[skill[i][3] + 1][skill[i][2]] += skill[i][5];
                sum[skill[i][3] + 1][skill[i][4] + 1] -= skill[i][5];
            }
            else{
                sum[skill[i][1]][skill[i][2]] += skill[i][5];
                sum[skill[i][1]][skill[i][4] + 1] -= skill[i][5];
                sum[skill[i][3] + 1][skill[i][2]] -= skill[i][5];
                sum[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];
            }
        }
        
        
        for(int i = 0; i < x + 1; i++){
            for(int j = 1; j < y + 1; j++){
                sum[i][j] += sum[i][j - 1];
            }
        }
        
        for(int j = 0; j < y + 1; j++){
            for(int i = 1; i < x + 1; i++){
                sum[i][j] += sum[i - 1][j];
            }
        }
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}