import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.offer(new int[]{priorities[i], i});
        }
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            // 여기서 뺏을때 만약에 하나라도 우선순위가 높은게 있으면 그냥 바로 넘어가야함
            boolean check = true;
            for(int[] n : q){
                if(n[0] > now[0]){
                    q.offer(now);
                    check = false;
                    break;
                }
            }
            // 근데 만약에 아니다?
            if(check) answer ++;
            if(check && now[1] == location) return answer;
        }
        
        return answer;
    }
}