import java.util.*;
class Solution {
    public int lenX;
    public int lenY;
    public int[][] d = {{0,1} , {1,0}, {-1, 0}, {0, -1}};
    public int solution(String[] maps) {
        lenX = maps.length;
        lenY = maps[0].length();
        
        int[] S = {0,0};
        int[] L = {0,0};
        int[] E = {0,0};
        for(int i = 0; i < lenX; i++){
            for(int j = 0; j < lenY; j++){
                if(maps[i].charAt(j) == 'S') S = new int[]{i ,j};
                if(maps[i].charAt(j) == 'L') L = new int[]{i ,j};
                if(maps[i].charAt(j) == 'E') E = new int[]{i ,j};
            }
        }
        
        int dist1 = bfs(S, L, maps);
        int dist2 = bfs(L, E, maps);
        
        if (dist1 == -1 || dist2 == -1){
            return -1;
        }
        
        return dist1 + dist2;
    }
    
    public int bfs(int[] start, int[] end, String[] maps){
        boolean[][] v = new boolean[lenX][lenY];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        v[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == end[0] && now[1] == end[1]){
                return now[2];
            }
            
            v[now[0]][now[1]] = true;
            for(int k = 0; k < 4; k++){
                int nx = now[0] + d[k][0];
                int ny = now[1] + d[k][1];

                if(0 <= nx && nx < lenX && 0 <= ny && ny < lenY){
                    if(!v[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        v[nx][ny] = true;
                        q.offer(new int[]{nx, ny, now[2] + 1});
                    }
                }
            }   
        }
        
        return -1;
    }
}