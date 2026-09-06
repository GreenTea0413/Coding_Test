import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int[][] arr = new int[n][n];
        // 1
        // 2
        // 3
        // 4 5 6 7
        int[][] d = {{1,0}, {0,1}, {-1, -1}};
        int dir = 0;
        int x = -1;
        int y = 0;
        int num = 1;
        int count = n;
        while(count > 0){
            for(int i = 0; i < count; i++){
                x += d[dir][0];
                y += d[dir][1];
                
                arr[x][y] = num;
                num++;
            }
            dir = (dir + 1) % 3;
            count--;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0) answer.add(arr[i][j]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}