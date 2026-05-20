import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int len = speeds.length;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < len; i++){
            int p = progresses[i];
            int s = speeds[i];
            
            int temp = 100 - p;
            int rest = temp / s;
            if(temp % s > 0){rest += 1;}
            q.offer(rest);
        }
        
        // [7, 4, 9]
        while(!q.isEmpty()){
            int count = 1;
            int now = q.poll();
            
            while(!q.isEmpty() && q.peek() <= now){
                count++;
                q.poll();
            }
            answer.add(count);
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}