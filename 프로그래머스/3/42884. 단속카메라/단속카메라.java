import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        // 카메라를 제일 처음부터 시작해서 어디까지 이어지나 보면 됨
        // 만약에 안이어지면 다음꺼 넘어가서 + 1
        
        Arrays.sort(routes, (a, b) -> (a[1] - b[1]));
        int camera = routes[0][1];
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] <= camera && camera <= routes[i][1]){continue;}
            else {camera = routes[i][1]; answer++;}
        }
        
        return answer;
    }
}