import java.util.*;

class Solution {
    boolean[][] wall;
    boolean[][] paper;
    int m;
    List<int[]> answer = new ArrayList<>();
    public int[][] solution(int n, int[][] build_frame) {
        wall = new boolean[n + 1][n + 1];
        paper = new boolean[n + 1][n + 1];
        m = n;
        for(int[] frame : build_frame){
            int x = frame[0]; int y = frame[1]; int a = frame[2]; int b = frame[3];
            // a / 0 -> 기둥 / 1-> 보
            // b / 0 -> 삭제 / 1 -> 설치
            
            // 삭제할 때
            if(b == 0){
                // 기둥 삭제 확인하기
                if(a == 0){
                    wall[x][y] = false;
                    if(!check()) wall[x][y] = true;
                }
                else{
                    paper[x][y] = false;
                    if(!check()) paper[x][y] = true;
                }
            }
            // 설치할 때
            else {
                if(a == 0){
                    wall[x][y] = true;
                    if(!check()) wall[x][y] = false;
                }
                else{
                    paper[x][y] = true;
                    if(!check()) paper[x][y] = false;
                }
                
            }
        }
        
        for(int i = 0; i <= n; i ++){
            for(int j = 0; j <= n; j++){
                if(wall[i][j]) answer.add(new int[]{i,j,0});
                if(paper[i][j]) answer.add(new int[]{i,j,1});
            }
        }
        
        Collections.sort(answer, (a,b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        return answer.toArray(new int[0][]);
    }
    
    boolean check(){
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= m; j++){
                if(wall[i][j] && !canWall(i, j)) return false;
                if(paper[i][j] && !canPaper(i, j)) return false;
            }
        }
        return true;
    }
    
    boolean canWall(int x, int y){
        // 바닥
        if(y == 0) return true;

        // 아래에 기둥
        if(wall[x][y - 1]) return true;

        // 오른쪽에 보
        if(paper[x][y]) return true;

        // 왼쪽에 보
        if(x > 0 && paper[x - 1][y]) return true;

        return false;
    }

    boolean canPaper(int x, int y){
        // 왼쪽 아래에 기둥
        if(y > 0 && wall[x][y - 1]) return true;

        // 오른쪽 아래에 기둥
        if(y > 0 && wall[x + 1][y - 1]) return true;

        // 양쪽에 보
        if(x > 0 && x < m &&
           paper[x - 1][y] && paper[x + 1][y]) return true;

        return false;
    }
}