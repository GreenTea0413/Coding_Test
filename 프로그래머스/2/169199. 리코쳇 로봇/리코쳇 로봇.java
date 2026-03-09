import java.util.*;

class Solution {
    // 0 ->,  1 <-,  2 v,  3 ㅅ
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public int solution(String[] board) {
        int max_x = board.length;
        int max_y = board[0].length();
        char[][] map = new char[max_x][max_y];
        int i = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        
        // 격자 배열 만들기
        for(String s : board){
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                map[i][j] = c;
                if(c == 'R') start = new int[]{i, j};
                if(c == 'G') end = new int[]{i, j};
            }
            i++;
        }
        
        // 방향에 따라 그냥 쭉감!
        // d에 부딪히면 d 빼고 나머지 방향으로 움직일 수 있음
        // 그럼 queue에 저장해야하는게 x좌표, y좌표, 방향, 횟수
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[max_x][max_y];
        q.offer(new int[]{start[0], start[1], 0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            int cc = now[2];
            if(cx == end[0] && cy == end[1]) return cc;

            // 여기서 출발 했을 때 방향대로 쭉 간다
            for(int d = 0; d < 4; d++){
                int nx = cx, ny = cy;
                // 벽/D 만날 때까지 쭉 이동
                while(true){
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];
                    if(tx < 0 || tx >= max_x || ty < 0 || ty >= max_y 
                       || map[tx][ty] == 'D') break;
                    nx = tx; ny = ty;
                }
                // 실제 이동했고 미방문이면 추가
                if((nx != cx || ny != cy) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cc + 1});
                }
            }
        }
        return -1;
    }
}