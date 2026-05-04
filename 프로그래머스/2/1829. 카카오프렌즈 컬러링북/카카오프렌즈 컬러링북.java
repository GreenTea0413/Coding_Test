import java.util.*;

class Solution {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    boolean[][] v;
    
    public int[] solution(int m, int n, int[][] picture) {
        v = new boolean[m][n];
        // picture안에 숫자도 같아야하고 상하좌우로 해서 방문 안했는지 비교해서 들어가야함
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!v[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(dfs(i, j, picture,1, picture[i][j], m, n), maxSizeOfOneArea);         
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int dfs(int x, int y, int[][] picture, int sqr, int num, int m, int n){
        int size = 1;
        v[x][y] = true;
        
        
        for(int k = 0; k < 4; k++){
            int nx = x + d[k][0], ny = y + d[k][1];                            
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(!v[nx][ny] && (num == picture[nx][ny])){
                v[nx][ny] = true;
                size += dfs(nx, ny, picture, sqr + 1, num, m, n);
            }
        }
        return size;
    }
}