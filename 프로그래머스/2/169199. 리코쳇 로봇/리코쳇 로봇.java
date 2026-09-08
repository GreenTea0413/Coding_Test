import java.util.*;

class Solution {
    public int solution(String[] board) {
       // 쭉 미끄러져서 가는 느낌
       // 도착 지점을 가져야함
       int[] start = {0,0};
       int[] end = {0,0};
        
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == 'R') start = new int[]{i, j};
                if(board[i].charAt(j) == 'G') end = new int[]{i, j};
            }
        }
        return bfs(start, end, board);
    }
    
    public int bfs(int[] start, int[] end, String[] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        
        int n = board.length;
        int m = board[0].length();
        boolean[][] v = new boolean[n][m];
        v[start[0]][start[1]] = true;
        
        int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] == end[0] && now[1] == end[1]) return now[2];
            
            for(int i = 0 ; i < 4; i++){
                // 한번 가면 그 방향으로 쭉 가야함
                // D를 만나던지 범위 끝에 가야함
                int nx = now[0];
                int ny = now[1];
                while(true){
                    int tx = nx + d[i][0];
                    int ty = ny + d[i][1];
                    
                    if(tx < 0 || tx >= n || ty < 0 || ty >= m || board[tx].charAt(ty) =='D') break;
                    nx = tx;
                    ny = ty;
                }
                
                if((nx != now[0] || ny != now[1]) && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        
        return -1;
    }
}