import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,(j1,j2) -> j1[0] - j2[0]);
        Queue<int[]> pq = new PriorityQueue<>((j1,j2) -> j1[1] - j2[1]);
        
        int idx = 0;
        int cur = 0;
        int total = 0;
        int job = 0;
        
        while(job<jobs.length){
            while(idx<jobs.length && jobs[idx][0] <= cur){
                pq.add(jobs[idx]);
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] j = pq.remove();
                
                cur += j[1];
                total += cur - j[0];
                job++;
            }
            else{
                cur = jobs[idx][0];
            }
        }
        
        return total / jobs.length;
    }
}