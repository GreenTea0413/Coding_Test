import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        
        // [총 다트 갯수, 싱글 or 불 갯수]
        int[][] dp = new int[target + 1][2];
        
        for(int i = 1; i <= target; i++){dp[i][0] = Integer.MAX_VALUE;}
        
        List<int[]> scores = new ArrayList<>();
        for(int i = 1; i <= 20; i++){
            scores.add(new int[]{i, 1});
            scores.add(new int[]{i * 2, 0});
            scores.add(new int[]{i * 3, 0});
        }
        scores.add(new int[]{50, 1});
        
        for(int i = 0; i <= target; i++){
            if(0 != i && dp[i][0] == Integer.MAX_VALUE) continue;
            
            for(int[] score : scores){
                // 다음 점수
                int next = i + score[0];
                if(next > target) continue;
                
                // 해당 점수의 다트 수 + 1 해야 다음 다트 수
                int dart = dp[i][0] + 1;
                int sb = dp[i][1] + score[1];
                
                if(dart < dp[next][0]){
                    dp[next][0] = dart;
                    dp[next][1] = sb;
                }
                else if(dart == dp[next][0] && sb > dp[next][1]){
                    dp[next][1] = sb;
                }
            }
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        return answer;
    }
}