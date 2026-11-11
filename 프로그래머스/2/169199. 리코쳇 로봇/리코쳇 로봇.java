import java.util.*;

class Solution {    
    public int solution(String[] board) {
        int xLen = board.length;
        int yLen = board[0].length();
        
        int[] start = new int[2];
        int[] end = new int[2];
        
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(board[i].charAt(j) == 'R') {start[0] = i; start[1] = j;}
                if(board[i].charAt(j) == 'G') {end[0] = i; end[1] = j;}
            }
        }
        
        // 이걸로 좌표를 x,y로 만들어서 중복 제거하기
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        
        boolean [][] v = new boolean[xLen][yLen];
        v[start[0]][start[1]] = false;
        
        int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1]; int cost = now[2];
            if(x == end[0] && y == end[1]) return cost;
            
            for(int i = 0; i < 4; i++){
                int nx = x; int ny = y;
                
                while(true){
                    int tx = nx + d[i][0];
                    int ty = ny + d[i][1];
                    if(tx < 0 || tx >= xLen || ty < 0 || ty >= yLen || board[tx].charAt(ty) == 'D') break;
                    nx = tx; ny = ty;
                }
                if((nx != now[0] || ny != now[1]) && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cost + 1});
                }
            }
        }
        return -1;
    }

}