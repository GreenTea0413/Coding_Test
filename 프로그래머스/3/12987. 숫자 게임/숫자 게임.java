import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0;
        int j = 0;
        int answer = 0;
        
        while (i < A.length && j < B.length){
            if (A[i] < B[j]){
                i++;
                j++;
                answer++;
            }
            else{
                j++;
            }
        }
        
        
        return answer;
    }
}