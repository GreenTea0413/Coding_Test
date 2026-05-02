import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] d = {{1,0}, {0,1}, {-1,-1}};
        int[][] result = new int[n][n];
        int x = -1;
        int y = 0;
        int dir = 0;
        int num = 1;
        
        for(int i = n; i > 0; i--){
            int count = i;
            
            while(count > 0){
                int nx = x + d[dir % 3][0];
                int ny = y + d[dir % 3][1];
                
                result[nx][ny] = num;
                num ++;
                count--;
                x = nx;
                y = ny;
            }
            dir ++;
        }
        
        for(int[] res : result){
            for(int r : res){
                if(r != 0) {answer.add(r);}
            } 
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}