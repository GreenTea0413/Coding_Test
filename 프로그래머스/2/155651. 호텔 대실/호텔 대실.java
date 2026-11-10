import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int len = book_time.length;
        int[][] arr = new int[len][2];
        for(int i = 0; i < len; i++){
            arr[i][0] = min(book_time[i][0]);
            arr[i][1] = min(book_time[i][1]);
        }
        
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < len; i++){
            int[] now = arr[i];
            while(!pq.isEmpty() && pq.peek() <= now[0]){
                pq.poll();
            }
            
            pq.offer(now[1] + 10);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    int min(String s){
        String[] str = s.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}