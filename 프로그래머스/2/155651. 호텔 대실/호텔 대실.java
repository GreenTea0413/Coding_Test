import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> (a[0].compareTo(b[0])));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < book_time.length; i++){
            int start = toNum(book_time[i][0]); int end = toNum(book_time[i][1]);
            
            while(!pq.isEmpty() && start >= pq.peek()){
                pq.poll();
            }
            
            pq.offer(end + 10);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    int toNum(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}