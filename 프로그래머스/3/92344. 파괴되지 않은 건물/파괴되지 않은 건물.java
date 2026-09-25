class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        // 누적합을 이용해서 풀어야하는 문제
        // 전부 다 구하면 터짐
        // 배열을 한칸씩 더 늘려서 끝점에 -1을 두어서 해당 좌표까지 다 더하지않게 하기
        int xLen = board.length;
        int yLen = board[0].length;
        int[][] arr = new int[xLen + 1][yLen + 1];
        
        for(int[] s : skill){
            int type = s[0]; int r1 = s[1]; int c1 = s[2]; int r2 = s[3]; int c2 = s[4]; 
            int degree = s[5];
            
            // -
            if(type == 1){
                // 좌표가 0,1 3,4면 0,0에 -degree를 넣고 0,5에는 +degree를 넣으면 쭉 내려가면서 -를 전파할때
                // 0,5에서 +5를 마주치기때문에 멈춤
                // 0,1 4,5
                // 0,5 4,1
                arr[r1][c1] -= degree; // 0,1
                arr[r2 + 1][c2 + 1] -= degree; // 4,5
                arr[r1][c2 + 1] += degree; // 0,5
                arr[r2 + 1][c1] += degree; // 4,1
            }
            // +
            else{
                arr[r1][c1] += degree;
                arr[r2 + 1][c2 + 1] += degree;
                arr[r1][c2 + 1] -= degree;
                arr[r2 + 1][c1] -= degree;
            }
        }
        
        // 범위 구한거를 이제 arr[i][j]에 대해서 각각 넣었으니 이제 범위에 맞게 값이 들어가도록 전체적으로 더해주기
        // ->>> 이렇게 가면서 값 바꿔주면 됨
        for(int i = 0 ; i < xLen + 1; i++){
            for(int j = 1; j < yLen + 1; j++){
                arr[i][j] += arr[i][j - 1];
            }
        }
        // 이번에는 아래로 내려가면서 구해주면 됨
        for(int i = 0 ; i < yLen + 1; i++){
            for(int j = 1; j < xLen + 1; j++){
                arr[j][i] += arr[j - 1][i];
            }
        }
        
        // 이렇게 범위 다 설정했으니까 board에 모든칸들에 arr에 계산한거 더해주고 0보다 크면 살아있는거니까 answer++;
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(board[i][j] + arr[i][j] > 0) answer ++;
            }
        }
        return answer;
    }
}