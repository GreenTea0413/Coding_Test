import java.util.*;

class Solution {
    int xLen; int yLen;
    public int solution(String[] maps) {
        int answer = 0;
        this.xLen = maps.length;
        this.yLen = maps[0].length();
        
        int[] S = new int[2];
        int[] L = new int[2];
        int[] E = new int[2];
        
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(maps[i].charAt(j) == 'S') {S[0] = i; S[1] = j;}
                if(maps[i].charAt(j) == 'L') {L[0] = i; L[1] = j;}
                if(maps[i].charAt(j) == 'E') {E[0] = i; E[1] = j;}
            }
        }
        
        int sl = bfs(S, L, maps, new boolean[xLen][yLen]);
        int le = bfs(L, E, maps, new boolean[xLen][yLen]);

        if(sl == -1 || le == -1) return -1;
        return sl + le;
    }
    int[][] d = {{0,1}, {0,-1},{1,0},{-1,0}};
    
    int bfs(int[] start, int[] end, String[] maps, boolean[][] v){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        v[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1]; int cost = now[2];
            
            if(x == end[0] && y == end[1]) return cost;
            
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0]; int ny = y + d[i][1];
                
                if(nx < 0 || nx >= xLen || ny < 0 || ny >= yLen) continue;
                if(!v[nx][ny] && maps[nx].charAt(ny) != 'X'){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cost + 1});
                }
            }
        }
        return -1;
    }
}