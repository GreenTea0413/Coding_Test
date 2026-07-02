import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] dp = new int[target + 1][2];
        
        for(int i = 1; i <= target; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        List<int[]> scores = new ArrayList<>();
        
        // 싱글
        for(int i = 1; i <= 20; i++){
            scores.add(new int[]{i, 1});
        }
        // 더블
        for(int i = 1; i <= 20; i++){
            scores.add(new int[]{i * 2, 0});
        }
        // 트리블
        for(int i = 1; i <= 20; i++){
            scores.add(new int[]{i * 3, 0});
        }
        // 불
        scores.add(new int[]{50, 1});
        
        for(int i = 0; i <= target; i++){
            if(i != 0 && dp[i][0] == Integer.MAX_VALUE) continue;
            // [20, 1], [21, 0] ...
            for(int[] score : scores){
                // 다음 점수
                int next = i + score[0];
                if(next > target) continue;
                
                // 다음으로 가는 다트 던진 갯수 
                int dart = dp[i][0] + 1;
                // 싱글이나 불로 가는 수
                int sb = dp[i][1] + score[1];
                    
                // 지금 던진 다트수랑 다음 점수의 다트수가 
                if(dart < dp[next][0]){
                    dp[next][0] = dart;
                    dp[next][1] = sb;
                }
                // 그리고 다트 갯수가 next랑 같으면 sb더 많은 쪽으로
                else if (dart == dp[next][0] && sb > dp[next][1]) {
                    dp[next][1] = sb;
                }        
            }
        }
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        return answer;
    }
}