import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int distance, int[] rocks, int n) {
        // 거리의 최솟값 중 최댓값
        int len = rocks.length;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(check(mid, rocks, distance, n)){
                answer = Math.max(answer,mid);
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return answer;
    }
    
    boolean check(int mid, int[] rocks, int distance, int n){
        int prev = 0;
        int removeCount = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - prev < mid) {
                removeCount++;
            }
            else{
                prev = rocks[i];    
            }
        }
        if(distance - prev < mid) removeCount++;
        if(removeCount > n) return false;
        return true;
    }
}