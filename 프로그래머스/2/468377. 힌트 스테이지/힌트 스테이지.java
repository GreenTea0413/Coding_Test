import java.util.*;

class Solution {
    int n;
    int[][] cost, hint;
    Map<String, Integer> memo = new HashMap<>();
    
    public int solution(int[][] cost, int[][] hint) {
        this.n = cost.length;
        this.cost = cost;
        this.hint = hint;
        
        int[] hints = new int[n + 1]; // hints[i] = i번 힌트권 보유 개수
        return dfs(0, hints);
    }
    
    // stage: 현재 스테이지 (0-indexed)
    // hints: 각 스테이지별 힌트권 보유 개수
    public int dfs(int stage, int[] hints) {
        if(stage == n) return 0;
        
        String key = stage + "," + Arrays.toString(hints);
        if(memo.containsKey(key)) return memo.get(key);
        
        // 현재 스테이지에서 사용 가능한 힌트 수
        int useHint = Math.min(hints[stage + 1], n - 1);
        int stageCost = cost[stage][useHint];
        int[] remainHints = hints.clone();
        remainHints[stage + 1] -= useHint;
        
        // 1. 번들 안 사는 경우
        int res = stageCost + dfs(stage + 1, remainHints);
        
        // 2. 번들 사는 경우 (마지막 스테이지 제외)
        if(stage < n - 1) {
            int bundlePrice = hint[stage][0];
            int[] newHints = remainHints.clone();
            for(int h = 1; h < hint[stage].length; h++) {
                newHints[hint[stage][h]]++;
            }
            res = Math.min(res, stageCost + bundlePrice + dfs(stage + 1, newHints));
        }
        
        memo.put(key, res);
        return res;
    }
}