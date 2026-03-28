import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 일단 끝나는 시간 + 10
        for(String[] book : book_time){
            // 시작 시간을 구하고
            int start = toNum(book[0]);
            
            // 현재 방 끝나는 시간이 담겨 있는 큐에서 지금 시작보다 작으면 다 버려야함
            while(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }
            
            // 그 다음 여기가 문제네..
            // 일단 청소해야하니까 일단 넣는게 맞는데 answer에 값을 어떻게 넣을 것인가..
            // 
            pq.offer(toNum(book[1]) + 10);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    
    public int toNum(String time){
        String[] min = time.split(":");
        return Integer.parseInt(min[0]) * 60 + Integer.parseInt(min[1]);
    }
}