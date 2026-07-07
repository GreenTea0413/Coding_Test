import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        // 5 1 3 7 -> 1 3 5 7
        // 2 2 6 8 -> 2 2 6 8
        
        int aIdx = 0;
        int bIdx = 0;
        
        while(bIdx < B.length){
            if(A[aIdx] < B[bIdx]){
                aIdx++;
                bIdx++;
                answer++;
            }
            else{
                bIdx++;
            }
        }
        
        return answer;
    }
}