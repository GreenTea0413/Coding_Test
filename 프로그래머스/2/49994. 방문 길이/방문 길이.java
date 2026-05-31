import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] arr = dirs.toCharArray();
        Set<String> v = new HashSet<>();
        
        // (5, 5)
        int x = 5, y = 5;
        for(int i = 0; i < arr.length; i++){
            
            int nx = x, ny = y;
            if(arr[i] == 'U'){
                if(y < 10){ny += 1;}
            }
            else if(arr[i] == 'D'){
                if(y > 0){ny -= 1;}
            }
            else if(arr[i] == 'L'){
                if(x > 0){nx -= 1;}
            }
            else {
                if(x < 10){nx += 1;}
            }
            
            if(nx == x && ny == y) continue;
            
            String str1 = "" + x + "," + y + "," + nx + "," + ny;
            String str2 = "" + nx + "," + ny + "," + x + "," + y;
            
            if(!v.contains(str1)){
                v.add(str1);
                v.add(str2);
                answer++;
            }
            x = nx; y = ny;
        }
        return answer;
    }
}