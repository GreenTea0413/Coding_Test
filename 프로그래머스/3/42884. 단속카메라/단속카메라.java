import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> (a[1] - b[1]));
        
        int last = -Integer.MAX_VALUE;
        for(int i = 0; i < routes.length; i++){
            if(last < routes[i][0]){
                answer++;
                last = routes[i][1];
            }
        }
        return answer;
    }
}