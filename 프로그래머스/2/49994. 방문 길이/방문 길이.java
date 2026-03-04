import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        Set<String> v = new HashSet<>();
        int[] robot = {5,5,0};
        
        int len = dirs.length();
        String[] dir = new String[len];
        for(int i = 0; i<len; i++){
            dir[i] = String.valueOf(dirs.charAt(i));
        }
        
        for(String s : dir){
            int x = robot[0];
            int y = robot[1];
            int dist = robot[2];
            int nx = x;
            int ny = y;
            
            if (s.equals("U")){
                if (y != 10){ ny += 1;}
            }
            else if (s.equals("D")){
                if (y != 0){ ny -= 1;}
            }
            else if (s.equals("L")){
                if (x != 0){nx -= 1;}
            }
            else if (s.equals("R")){
                if (x != 10){nx += 1;}
            }
            
            if (x == nx && y == ny) {
                robot = new int[]{nx, ny, dist};
                continue;
            }
            
            String key1 = x + "," + y + "," + nx + "," + ny;
            String key2 = nx + "," + ny + "," + x + "," + y;
                     
            if (!v.contains(key1)) {
                dist += 1;
                v.add(key1);
                v.add(key2);  
            }
            robot = new int[]{nx,ny,dist};
        }
        return robot[2];
    }
}