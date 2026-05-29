import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 인덱스, 우선순위
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.offer(new int[]{i, priorities[i]});
        }
        
        while(!q.isEmpty()){
            // [0, 2]
            int[] now = q.poll();
            boolean check = false;
            
            for(int[] next : q){
                if(next[1] > now[1]){
                    q.offer(now);
                    check = true;
                    break;
                }
            }
            
            if(!check){
                answer ++;
                if(location == now[0]){
                    return answer;
                }
            }
        }
        return answer;
    }
}