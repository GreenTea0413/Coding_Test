import java.util.*;

class Solution {
    public int solution(int[][] targets) {    
        // A나라는 x축에 평행 -  폭격미사일
        // B나라는 y축에 수평 |  요격미사일
        
        // 여기서는 x가[][여기] 가로니까 [4,8] 이 저런 모양임
        // 그래서 이제 최대한 많이 겹치는 부분에 미사일을 쏴야지 최소다
        // 그리고 양끝에서는 못터트림 [5 ~ 7] 로만 막을 수 있음
        
        // 그러면 일단 젤 앞에서부터 처리하도록 하기
        Arrays.sort(targets, (a, b) -> {if(a[0] == b[0]) return a[1] - b[1]; return a[0] - b[0];});
        int start = targets[0][0];
        int end = targets[0][1];
        int answer = 1;
        for(int i = 1; i < targets.length; i++){
            int[] t = targets[i];
            
            if(t[0] < end) {
                end = Math.min(end, t[1]); continue;
            }
            end = t[1];
 
            answer++;
        }
        
        return answer;
    }
}