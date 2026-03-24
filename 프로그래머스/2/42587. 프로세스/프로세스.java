import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < len; i++){
            q.offer(new int[]{i, priorities[i]});
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            boolean isHigher = false;
            for(int[] qn : q){
                if(qn[1] > cur[1]){
                    isHigher = true;
                    break;
                }
            }
            
            if(isHigher){
                q.offer(cur);
            }
            else{
                answer++;
                if(cur[0] == location) {
                    return answer;
                };
            }
        }
        return answer;
    }
}