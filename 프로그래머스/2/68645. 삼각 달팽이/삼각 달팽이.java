import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] dp = new int[n+1][n+1];
        List<Integer> answer = new ArrayList<>();
        int[][] d = {{1, 0}, {0, 1}, {-1, -1}};
        int len = n;
        int dir = 0;
        int count = 0;
        int num = 1;
        int x = 0;
        int y = 0;
        
        while(n > 0){
            x = x + d[dir % 3][0];
            y = y + d[dir % 3][1];
            dp[x][y] = num;
            num++;
            count++;
            if(count == n){
                n--;
                count = 0;
                dir += 1;
            }
        }
        
        for(int i = 1; i < len + 1; i++){
            for(int j = 0; j < len; j++){
                if (dp[i][j] != 0){
                    answer.add(dp[i][j]);
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}