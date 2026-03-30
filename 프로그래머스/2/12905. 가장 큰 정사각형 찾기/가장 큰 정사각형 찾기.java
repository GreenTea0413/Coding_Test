class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        
        for(int i = 0; i < board.length; i++)
            answer = Math.max(answer, board[i][0]);
        for(int j = 0; j < board[0].length; j++)
            answer = Math.max(answer, board[0][j]);
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                if(board[i][j] == 1){
                    board[i][j] = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;
                }
                answer = Math.max(board[i][j], answer);
            } 
        }
        return answer * answer;
    }
}