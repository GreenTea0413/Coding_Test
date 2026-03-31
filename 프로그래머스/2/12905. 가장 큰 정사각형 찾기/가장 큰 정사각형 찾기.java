class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int lenX = board.length;
        int lenY = board[0].length;
        for(int i = 0; i < lenX; i++){
            answer = Math.max(answer, board[i][0]);
        }
        
        for(int i = 0; i < lenY; i++){
            answer = Math.max(answer, board[0][i]);
        }
        
        for(int i = 1; i < lenX; i++){
            for(int j = 1; j < lenY; j++){
                if(board[i][j] == 1){
                board[i][j] = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;}
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }
}