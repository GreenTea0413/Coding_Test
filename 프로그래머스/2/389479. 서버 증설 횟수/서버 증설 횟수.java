import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int answer = 0;
        int now_server = 0;

        for (int i = 0; i < 24; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                int[] s = pq.poll();
                now_server -= s[1];
            }

            int need_server = players[i] / m;

            if (now_server < need_server) {
                int gap = need_server - now_server;
                pq.offer(new int[]{i + k, gap});
                now_server += gap;
                answer += gap;
            }
        }
        return answer;
    }
}