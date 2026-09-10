import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // 음 값들을 기억하고 빼야하는거 같은데
        // 그러면 우선순위로 큰값이 먼저 나오게 하는거임
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int len = enemy.length;
        
        for(int i = 0; i < len; i++){
            int e = enemy[i];
            // 만약에 안 넘어가면? 넣어놓기
            // 7 - 4 에서 4를 pq에 넣는다 아니지 모든 값을 그냥 pq에 넣기
            pq.offer(e);
            n -= e;
            answer++;
            // 여기서 이제 n이 < 0 으로가면 
            if(n < 0){
                if(k == 0) { answer--; break; }
                // 대신에 k 무적권이 있어야 가능
                // 그러면 현재 n이 원래 7인에 -4 -2 했고 그 다음 4가 또와서 여기 들어오면
                // 여기서 pq에서 하나빼고 n이 -e 한것보다 커질때까지 pq에서 큰걸 빼야하는가?
                while(k > 0 && n < 0){
                    int prev = pq.poll();
                    n += prev;
                    k--;
                }
            }
        }
        
        return answer;
    }
}