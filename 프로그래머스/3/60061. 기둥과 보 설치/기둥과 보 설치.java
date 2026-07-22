import java.util.*;

class Solution {
    boolean[][] board;
    boolean[][] wall;
    int m;
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();
        board = new boolean[n + 1][n + 1];
        wall = new boolean[n + 1][n + 1];
        m = n;
        
        // a 0 기둥, 1 보
        // b 0 삭제, 1 설치
        for(int[] bf : build_frame){
            int x = bf[0];
            int y = bf[1];
            int a = bf[2];
            int b = bf[3];
            
            // 설치
            if(b == 1){
                // 기둥
                if(a == 0){
                   wall[x][y] = true;
                   if(!check()) wall[x][y] = false;
                }
                // 보
                else{
                    board[x][y] = true;
                    if(!check()) board[x][y] = false;
                }
            }
            // 삭제
            else{
                if(a == 0){
                    wall[x][y] = false;
                    if(!check()) wall[x][y] = true;
                }
                else{
                    board[x][y] = false;
                    if(!check()) board[x][y] = true;
                }
            }
        }
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(board[i][j]) answer.add(new int[]{i,j,1});
                if(wall[i][j]) answer.add(new int[]{i,j,0});
            }
        }
        Collections.sort(answer, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        return answer.toArray(new int[0][]);
    }
    
    public boolean check(){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(wall[i][j] && !canWall(i, j)){return false;}
                if(board[i][j] && !canBoard(i, j)){return false;}
            }
        }
        return true;
    }
    
    public boolean canBoard(int x, int y){
        if(wall[x][y - 1]) return true;
        if(y > 0 && wall[x + 1][y - 1]) return true;
        if(x > 0 && board[x - 1][y] && board[x + 1][y]) return true;
        
        return false;
    }
    
    public boolean canWall(int x, int y){
        if(y == 0) return true;
        if(wall[x][y - 1] || board[x][y]) return true;
        if(x > 0 && board[x - 1][y]) return true;
        
        return false;
    }
}