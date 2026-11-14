import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];});
        
        // 끝점끼리는 겹쳐서 못 없앰
        // start 와 end 사이에 다음 타겟의 시작점이 들어온다면 continue
        // 아니면 새롭게 start와 end를 업데이트 해주기
        int start = targets[0][0];
        int end = targets[0][1];
        answer++;
        for(int i = 1; i < targets.length; i++){
            if(targets[i][0] < end) {
                end = Math.min(end, targets[i][1]);
                continue;
            }
            
            end = targets[i][1];
            answer++;
        } 
        return answer;
    }
}