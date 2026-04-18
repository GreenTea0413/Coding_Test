import java.util.*;
class Solution {
    public int[] answer;
    public int diff;
    public int[] solution(int n, int[] info) {
        diff = -1; 
        answer = new int[]{-1};
        dfs(n, 0, new int[11], info);

        return answer;
    }
    
    public void dfs(int n, int idx, int[] lion, int[] info){
        if(idx == 11){
            int lionScore = 0;
            int apeachScore = 0;

            lion[10] += n;

            for(int i = 0; i < 11; i++){
                if(lion[i] > info[i]) lionScore += 10 - i;
                else if(info[i] > 0) apeachScore += 10 - i;
            }

            int gap = lionScore - apeachScore;

            if(gap > 0){
                if(diff < gap || (diff == gap && isLower(lion, answer))){
                    diff = gap;
                    answer = lion.clone();
                }
            }

            lion[10] -= n; 
            return;
        }
        
        if(n >= info[idx] + 1){
            lion[idx] = info[idx] + 1;
            dfs(n - (info[idx] + 1), idx + 1, lion, info);
            lion[idx] = 0;
        }
        
        dfs(n, idx + 1, lion, info);
    }
    
    // 낮은 점수존을 더 많이 가진지 비교
    public boolean isLower(int[] lion, int[] answer){
        for(int i = 10; i >= 0; i--){
            if(lion[i] != answer[i])
                return lion[i] > answer[i];
        }
        return false;
    }
}