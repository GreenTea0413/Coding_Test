import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] dp = new int[target + 1][2];
        for(int i = 1; i <= target; i++) dp[i][0] = Integer.MAX_VALUE;
        
        // 두 선수 중 "싱글" 또는 "불"을 더 많이 던진 선수가 승리
        // [던진 횟수, 싱글 or 불 던진횟수]
        // 더블, 트리플은 0
        List<int[]> scores = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            scores.add(new int[]{i, 1});
            scores.add(new int[]{i * 2, 0});
            scores.add(new int[]{i * 3, 0});
        }
        scores.add(new int[]{50, 1});
        
      
        for(int i = 0; i < target; i++){
            if(i != 0 && dp[i][0] == Integer.MAX_VALUE) continue;
            // dp를 활용해서 점수 하나씩 다 꺼내서 0점부터 다음 점수까지
            // 몇개의 다트를 쓸지 정하기
            for(int[] score : scores){
                // 우선 dp에 대해서 dp[1][1] = 1
                // 다음 dp[2][0] = 1 (더블이 가능하니까)
                
                int nextScore = i + score[0];
                int nextDart = dp[i][0] + 1;
                int singleBull = dp[i][1] + score[1];
                
                if(nextScore > target) continue;
                
                // 다음 점수의 다트수보다 지금 1에서 점수로 갈때 더 적다면?
                if(nextDart < dp[nextScore][0]){
                    dp[nextScore][0] = nextDart;
                    dp[nextScore][1] = singleBull;
                }
                // 만약에 점수가 같은데 다트수도 같다면? singleBull만 체크
                else if(nextDart == dp[nextScore][0] && singleBull > dp[nextScore][1]) 
                    dp[nextScore][1] = singleBull;
                
            }
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        return answer;
    }
}