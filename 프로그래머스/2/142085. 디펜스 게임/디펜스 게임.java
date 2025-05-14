import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        if(enemy.length == k){
            return k;
        }
        // 라운드가 순서대로 흘러가는데 어떻게 막을 것인가
        // 자 그냥 순서대로 진행 하다가 막힐 때 마다 우선순위에 있는거 빼면 됨
        // 그러면 라운드 신경 안쓰고 가능
        // 1부터 진행 하되 막히는 순간 가장 큰 숫자 다시 더해줘서 진행
        for(int i =0; i < enemy.length; i ++){
            n -= enemy[i];
            pq.add(enemy[i]);
            answer += 1;
            if(n < 0){
                if(k > 0 && !pq.isEmpty()){
                    n += pq.poll();
                    k--;
                }
                else{
                    answer -= 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}