import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 끝점을 기억하기
        int min = -30001;
        
        for(int[] route : routes){
            if(min < route[0]){
                answer++;
                min = route[1];
            }
        }
        
        return answer;
    }
}