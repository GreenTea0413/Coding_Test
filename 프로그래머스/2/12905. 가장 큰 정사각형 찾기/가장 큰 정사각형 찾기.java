class Solution
{
    public int solution(int[][] board)
    {
        int xLen = board.length;
        int yLen = board[0].length;
        int answer = board[0][0];
        // dp로 풀어야함
        // 1,1 부터 n,n까지 갈 예정
        // 해당 좌표가 1이여야하고 왼쪽, 왼쪽 대각선, 위의 최솟값을 구해서 더해야가햠
        // 하나라도 0이면 정사각형이 안되기 때문에 anwer값을 그대로 1로 유지
        
        for(int i = 1; i < xLen; i++){
            for(int j = 1; j < yLen; j++){
                if(board[i][j] == 1){
                    board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j])) + 1;
                    answer = Math.max(board[i][j], answer);        
                    
                }
            }
        }
        

        return answer * answer;
    }
}