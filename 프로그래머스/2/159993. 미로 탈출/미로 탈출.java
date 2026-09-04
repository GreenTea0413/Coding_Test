import java.util.*;

class Solution {
    int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int n = 0;
    int m = 0;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        // S-> L로 가는 최적의 경로
        // L-> E로 가는 최적의 경로
        int[] S = new int[2];
        int[] L = new int[2];
        int[] E = new int[2];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) == 'S') S = new int[]{i, j};
                if(maps[i].charAt(j) == 'L') L = new int[]{i, j};
                if(maps[i].charAt(j) == 'E') E = new int[]{i, j};
            }
        }
        
        int dist1 = bfs(S, L, maps, new boolean[n][m]);
        int dist2 = bfs(L, E, maps, new boolean[n][m]);
        
        if(dist1 == 0 || dist2 == 0) return -1;
        return dist1 + dist2;
    }
    
    public int bfs(int[] start, int[] end, String[] maps, boolean[][] v){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        v[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] == end[0] && now[1] == end[1]) return now[2];
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + d[i][0];
                int ny = now[1] + d[i][1];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if(!v[nx][ny] && maps[nx].charAt(ny) != 'X'){
                    q.offer(new int[]{nx, ny, now[2] + 1});
                    v[nx][ny] = true;
                }
            }
        }
        return 0;
    }
}