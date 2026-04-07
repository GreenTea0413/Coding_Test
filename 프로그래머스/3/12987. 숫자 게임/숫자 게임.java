import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // N명씩 두팀
        // 둘다 정렬하고 하면 되는거 아닌가?
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        int j = 0;
        
        // 만약에 B의 값이 더 크다면?
        // 그 때는 answer += 1 left += 1해서 다음꺼로 가면됨
        
        // 만약에 A의 값이 더 크다면?
        // 그러면 left += 1만 해서 A의 다음 숫자와 B첫번째 숫자로 해서 비교해야할듯?
        while(i < A.length && j < B.length){
            if(A[i] < B[j]){
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