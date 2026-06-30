import java.util.*;

class Solution {
    boolean[][] wall;
    boolean[][] paper;
    int len;
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();
        len = n;
        wall = new boolean[n + 1][n + 1];
        paper = new boolean[n + 1][n + 1];

        for(int i = 0; i < build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            
            // 설치
            // a 0은 기둥, 1은 보
            // b 0은 삭제, 1은 설치
            if(b == 1){
                if(a == 0) {
                    wall[x][y] = true;
                    if(!checkAll()){wall[x][y] = false;}
                }
                else{
                    paper[x][y] = true;
                    if(!checkAll()){paper[x][y] = false;}
                }
            }
            // 삭제
            else{
                if(a == 0) {
                    wall[x][y] = false;
                    if(!checkAll()){wall[x][y] = true;}
                }
                else{
                    paper[x][y] = false;
                    if(!checkAll()){paper[x][y] = true;}
                }
            }
            
        }
        
        Collections.sort(answer, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(wall[i][j]){answer.add(new int[]{i, j, 0});}
                if(paper[i][j]){answer.add(new int[]{i, j, 1});}
            }
        }
        return answer.toArray(new int[0][]);
    }
    
    public boolean checkAll(){
        for(int i = 0; i <= len; i++){
            for(int j = 0; j <= len; j++){
                if(wall[i][j] && !canWall(i,j)){return false;}
                if(paper[i][j] && !canPaper(i,j)){return false;}
            }
        }
        return true;
    }
    
    public boolean canPaper(int x, int y){
        if(wall[x][y - 1]) return true;
        if(y > 0 && wall[x + 1][y - 1]) return true;
        if(x > 0 && paper[x - 1][y] && paper[x + 1][y]) return true;
        
        return false;
    }
    public boolean canWall(int x, int y){
        if (y == 0) return true;
        if(wall[x][y - 1] || paper[x][y]) return true;
        if(x > 0 && paper[x - 1][y]) return true;
        
        return false;
    }
}