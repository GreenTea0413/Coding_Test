import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len; i++){
            queue.offer(new int[]{priorities[i], i});
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            boolean hasHigher = false;

            for (int[] q : queue) {
                if (q[0] > now[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(now);
            } else {
                answer++;
                if (now[1] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}