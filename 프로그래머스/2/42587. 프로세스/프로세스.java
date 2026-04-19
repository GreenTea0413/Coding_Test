import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // priorities 0부터 시작하는 idx ,우선순위 적혀있는 value
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i < priorities.length; i++){
            q.offer(new int[]{i, priorities[i]});
        } 
    
        while(!q.isEmpty()){
            int[] next = q.poll();
            int time = next[1];
            
            boolean isHigher = false;
            for(int[] arr : q){
                if(arr[1] > next[1]){
                    isHigher = true;
                    break;
                }
            }
            
            if(isHigher) q.offer(next);
            else{
                answer ++;
                if(next[0] == location){
                    return answer;
                }
            }
        }
        
        
        return answer;
    }
}