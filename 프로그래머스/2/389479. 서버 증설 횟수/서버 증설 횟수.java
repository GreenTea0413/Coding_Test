import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        // m 미만이면 서버 증설 안시킴
        // 그러면 서버는 k 시간만큼 유지됨
        // k = 5, 2 ~ 7 
        // 근데 문제는 m * 2면 서버를 최대 2개까지 증설 시켜야함
        // 시간, 열려있는 서버 개수
        // 처음에 다 0개로 해놓기
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 50; i++){
            map.put(i, 0);
        }
        // 24시간 1시간 마다 반복할거임
        for(int i = 0; i < 24; i++){
            // 그 시간대 플레이어가 몇명
            int num = players[i];
            int quo = num / m;
            
            if (quo == 0){
                continue;
            }
            
            else if(quo > 0){
                // 현재 열려있는 서버의 갯수를 알아야함
                int rest = num % m;
                // 그럼 반대로 서버가 작다면 추가해야함
                if (map.get(i) < quo){
                    int gap = quo - map.get(i);
                    answer += gap;
                    for(int j = 0 ; j < k; j++){
                        map.put(i + j, map.get(i + j) + gap);
                    }
                }
            }
            
        }
        return answer;
    }
}