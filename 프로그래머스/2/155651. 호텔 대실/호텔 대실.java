import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // 나가면 청소하는데 + 10분
        // 끝나는 시간보다 작으면 다음 방
        // 그러면 book_time을 정렬해서 앞이 작은거 먼저 나오도록 하기
        // 14:10이 시작이고 끝나는 시간은 19:20으로 방 1개
        // 다음 1420인데 끝나는 시간 보다 작으니 방 + 1
        // 그러면 큐를 활용해서 다음 방보다 시간이 작으면 내보내기
        // 그리고 아니면 큐에 채워서 방 갯수 늘리기
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < book_time.length; i++){
            String[] book = book_time[i];
            int start = toMin(book[0]);
            int end = toMin(book[1]) + 10;
            // 1410 1920일때 
            // 1920 + 10 한게 들어가고 만약에 다음 start가 1920 + 10 보다 작으면 q에 들어가야함
            while(!pq.isEmpty() && start >= pq.peek()){
                int n = pq.poll();
                System.out.println(n);
            }
            pq.offer(end);
            answer = Math.max(pq.size(), answer);
        }
        return answer;
    }
    
    int toMin(String s){
        String[] time = s.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}