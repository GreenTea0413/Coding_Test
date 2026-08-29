import java.util.*;

class Solution {
    // U D R L
    int[][] d = {{0,1},{0,-1},{1,0}, {-1,0}};
    
    public int solution(String dirs) {
        // 중복을 빼야함
        Set<String> set = new HashSet<>();
        int answer = 0;
        int x = 0; int y = 0;
        
        for(char c : dirs.toCharArray()){
            int nx = x; int ny = y;
            if(c == 'U') {nx += d[0][0]; ny += d[0][1];}
            else if(c == 'D') {nx += d[1][0]; ny += d[1][1];}
            else if(c == 'R') {nx += d[2][0]; ny += d[2][1];}
            else if(c == 'L') {nx += d[3][0]; ny += d[3][1];}
            
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            
            String str1 = "" + x + "," + y + "," + nx + "," + ny;
            String str2 = "" + nx + "," + ny + "," + x + "," + y;
            
            if(!set.contains(str1)){
                set.add(str1);
                set.add(str2);
                answer++;
            }
           
            x = nx; y = ny;
        }
        
        return answer;
    }
}