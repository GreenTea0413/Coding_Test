import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (a, b) -> {
            return a[0].compareTo(b[0]);
        });
        
        for(String[] b : book_time){
            int start = toNum(b[0]);
            int end = toNum(b[1]) + 10;
            
            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }
            pq.offer(end);
        }
        return pq.size();
    }
    public int toNum(String str){
        String[] s= str.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}