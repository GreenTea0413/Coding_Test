import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
        // -5 지점, -15 지점
        // 그러면 일단 젤 앞에서 부터 넣는다 생각하고 -15가 -18보다 작으니까 포함된다
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int camera = -30001;
        
        // 그러면 카메라를 가장 맨 앞에 둬야함
        // 처음에 카메라가 -15에 위치하게 되고 그 다음에 -14가 오게 됨
        // route[0]이 카메로 보다 크면 안겹치는걸 알 수 있음
        for(int[] route : routes){
            if(route[0] > camera){
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}