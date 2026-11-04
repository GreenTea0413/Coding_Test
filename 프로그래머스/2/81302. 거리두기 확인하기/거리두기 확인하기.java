import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++)if(check(places[i])) answer[i] ++;
        return answer;
    }
    
    boolean check(String[] places){
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(places[i].charAt(j) == 'P') q.offer(new int[]{i, j});
            }
        }
        
        // 상하좌우에 일단 P있으면 바로 아웃!
        // 그리고 대각선에 있으면 거기서 1,1이면 0,1이랑 1,0 에 X쳐져있어야함
        int[][] d1 = {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
        int[][] d2 = {{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0]; int y = now[1];
            
            for(int i = 0; i < 4; i++){
                int nx = x + d1[i][0]; int ny = y + d1[i][1];
                
                if(0 > nx || 5 <= nx || 0 > ny || 5 <= ny) continue;
                if(places[nx].charAt(ny) == 'P') return false;
                else if(places[nx].charAt(ny) =='O'){
                    int cx = nx + d1[i][0]; int cy = ny + d1[i][1];
                    if(0 > cx || 5 <= cx || 0 > cy || 5 <= cy) continue;
                    if(places[cx].charAt(cy) == 'P') return false;
                }
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + d2[i][0]; int ny = y + d2[i][1];
                
                if(0 > nx || 5 <= nx || 0 > ny || 5 <= ny) continue;
                if(places[nx].charAt(ny) == 'P'){
                    // 3,4 -> 4,5 그러면 3,5랑 4,4확인
                    if(places[x].charAt(ny) == 'X' && places[nx].charAt(y) == 'X') continue;
                    else return false;
                } 
            }
        }
        
        
        return true;
    }
}