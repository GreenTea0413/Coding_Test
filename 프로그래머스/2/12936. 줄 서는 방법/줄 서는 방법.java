import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        // 팩토리얼 미리 계산
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++) factorial[i] = factorial[i-1] * i;
        
        // 사용 가능한 숫자 목록
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) nums.add(i);
        
        k--; // 0-indexed로 변환
        
        for(int i = n; i >= 1; i--){
            long fact = factorial[i - 1];
            int idx = (int)(k / fact); // 몇 번째 숫자 선택
            answer[n - i] = nums.get(idx);
            nums.remove(idx);
            k %= fact;
        }
        
        return answer;
    }
}