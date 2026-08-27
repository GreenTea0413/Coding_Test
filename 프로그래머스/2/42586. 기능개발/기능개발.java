import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int l = speeds.length;
        // 남은 일 횟수
        // 7 3 9
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < l; i++){
            int rest = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) rest++;
            
            q.offer(rest);
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            int num = 1;
            while(!q.isEmpty() && q.peek() <= now){
                q.poll();
                num++;
            }
            answer.add(num);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}