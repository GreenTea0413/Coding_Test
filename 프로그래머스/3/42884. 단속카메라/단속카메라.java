import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> { 
            return a[1] - b[1];
        });
        
        int min = - Integer.MAX_VALUE;
        for(int[] r : routes){
            if(min < r[0]){
                min = r[1];
                answer++;
            }
            
        }
        return answer;
    }
}