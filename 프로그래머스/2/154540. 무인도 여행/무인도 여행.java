import java.util.*;

class Solution {
    int[][] d = {{0,1}, {0,-1}, {1,0},{-1,0}};
    int[][] board;
    boolean[][] v;
    int xLen;
    int yLen;
    public int[] solution(String[] maps) {
        xLen = maps.length;
        yLen = maps[0].length();
        board = new int[xLen][yLen];
        v = new boolean[xLen][yLen];
        
        int count = 0;
        // X는 0으로 유지하고 나머지는 숫자로 넣기
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                char m = maps[i].charAt(j);
                
                if(m == 'X') {count++; continue;}
                board[i][j] = Integer.parseInt(String.valueOf(m));
            }
        }
        
        if(count == xLen * yLen) return new int[]{-1};
        
        List<Integer> answer = new ArrayList<>();
        
        
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(board[i][j] != 0 && !v[i][j]){
                    answer.add(dfs(i, j));
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    int dfs(int x, int y){
        int sum = board[x][y];
        v[x][y] = true;
    
        for(int i = 0; i < 4; i++){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            
            if(nx < 0 || nx >= xLen || ny < 0 || ny >= yLen) continue;
            if(!v[nx][ny] && board[nx][ny] != 0){
                v[nx][ny] = true;
                sum += dfs(nx, ny);
            }
        }
        
        return sum;
    }
}