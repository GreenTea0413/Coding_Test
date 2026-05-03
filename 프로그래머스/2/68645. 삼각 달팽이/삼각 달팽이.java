import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] d = {{1,0}, {0,1}, {-1,-1}};
        int[][] maps = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;
        int dir = 0;
        
        for(int i = n; i > 0; i--){
            for(int j = 0; j < i; j++){
                x += d[dir][0];
                y += d[dir][1];
                maps[x][y] = num++;
            }
            dir = (dir + 1) % 3;
        }
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer.add(maps[i][j]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}