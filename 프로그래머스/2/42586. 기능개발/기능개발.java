import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int rest = 100 - progresses[i];
            if(rest % speeds[i] > 0) q.offer(rest / speeds[i] + 1);
            else q.offer(rest / speeds[i]);
        }
        
        int now = 0;
        while(!q.isEmpty()){
            now = q.poll();
            int count = 1;
            while(!q.isEmpty() && now >= q.peek()){
                q.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}