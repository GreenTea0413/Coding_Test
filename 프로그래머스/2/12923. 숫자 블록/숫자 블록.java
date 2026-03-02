import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];
        
        for (long i = 1; i <= end / 2 && i <= 10_000_000; i++) {
            long start = (begin / i) * i;
            if (start < begin) start += i;
            if (start == i) start += i; 
            
            for (long j = start; j <= end; j += i) {
                answer[(int)(j - begin)] = (int)i;
            }
        }
        
        return answer;
    }
}