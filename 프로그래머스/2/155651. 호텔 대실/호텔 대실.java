import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 끝나는 시간을 넣어서 앞에 시작시간들이랑 비교 하기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for(String[] book : book_time){
            int start = toMin(book[0]);
            int end = toMin(book[1]);
            // 기존 방의 종료시간 보다 시작시간이 더 뒤에 있으면 방빼!
            while(!pq.isEmpty() && pq.peek() + 10 <= start){
                pq.poll();   
            }
            
            pq.add(end);
            answer = Math.max(pq.size(), answer);
        }       
        return answer;
    }
    
    public int toMin(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]) ;
    }
}