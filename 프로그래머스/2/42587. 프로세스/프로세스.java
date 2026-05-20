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
            int[] next = q.poll();
            int p = next[1];
            
            boolean higher = false;
            for(int[] a : q){
                if(a[1] > p){
                    higher = true;
                    break;
                }
            }
            
            if(higher) q.offer(next);
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