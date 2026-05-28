import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int len = speeds.length;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < len; i++){
            int work = 100 - progresses[i];
            int rest = work / speeds[i];
            if(work % speeds[i] >= 1){rest += 1;}
            
            // 7 3 9
            q.offer(rest);
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
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