import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int len = speeds.length;
        // 100 - 진행률 / 속도
        // 7, 3, 9
        // 그러면 첫번째 진행하는 동안 숫자가 이거보다 작으면 계속해서 빼서 없애기
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < len; i++){
            int time = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0) time += 1;
            q.offer(time);
        }
        while(!q.isEmpty()){
            int next = q.poll();
            int count = 1;
            while(!q.isEmpty() && next >= q.peek()){
                q.poll();
                count += 1;
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}