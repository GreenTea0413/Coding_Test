import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int len = progresses.length;
        // 작업이 진행되는 동안 다음 작업들이 같이끝나거나 빨리 끝나면 동시에 여러개 처리 가능
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i <len; i++){
            int work = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0) work ++;
            q.offer(work);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            int count = 1;
            while(!q.isEmpty() && q.peek() <= now){
                q.poll(); count++;
            }
            list.add(count);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}