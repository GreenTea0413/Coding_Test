import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int len = book_time.length;
        Arrays.sort(book_time, (a, b) -> {
           return a[0].compareTo(b[0]);
        });
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < len; i++) q.offer(new int[]{min(book_time[i][0]), min(book_time[i][1])});
        
        int idx = 0;
        // 끝나는 시간만 담아서 비교하기 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            while(!pq.isEmpty() && pq.peek() <= now[0]){
                idx++;
                pq.poll();
            }
            
            pq.offer(now[1] + 10);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    
    int min (String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}