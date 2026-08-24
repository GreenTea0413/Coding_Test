import java.util.*;

class Solution
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        int l = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < l; i++){
            answer += A[i] * B[l - i - 1];
        }
        return answer;
    }
}