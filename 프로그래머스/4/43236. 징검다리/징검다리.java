import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        // 0, 2, 11, 14, 17, 21, 25     - 바위
        //   2, 9, 3, 3, 4, 4           - 거리
        // 지금 딱 이렇게 까지 만들어 놨음
        
        // for(int i = 0; i < rocks.length; i++) System.out.println(rocks[i]);
        
        int left = 1;
        int right = distance;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            int prev = 0;
            // 그냥 이전 바위 위치만 구해놓고 다음 값에서 현재 위치를 뺏을 때 mid보다 작으면
            // count 올려주고 아니면 위치 변수 다시 저장
            // 굳이 매번 새로 꺼내서 할 필요 없고 이렇게 제거하거나 안하는 경우를 따져서
            // 앞에 값만 바꿔주거나 유지하면 계속 mid와 비교할 수 있는 다음 거리를 쉽게
            // 구할 수 있음
            for (int rock : rocks){
                if(rock - prev < mid){
                    count ++;
                }
                else{
                    prev = rock;
                }
            }
            
            // 이렇게 하고 마지막에 distance에 대해서도 진행
            if(distance - prev < mid){
                count++;
            }
            // 너무 많이 제거하면 거리 줄이기
            if(count > n){
                right = mid - 1;
            }
            else{
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}