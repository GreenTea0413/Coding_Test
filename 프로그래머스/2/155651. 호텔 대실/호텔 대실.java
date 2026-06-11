import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> {return a[0].compareTo(b[0]);});
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String[] book : book_time){
            int start = toMin(book[0]);
            int end = toMin(book[1]);
            
            while(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }
            
            pq.offer(end + 10);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    public int toMin(String s){
        String[] arr= s.split(":");
        
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}