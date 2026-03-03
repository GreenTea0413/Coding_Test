import java.util.*;

class Solution {
    
    public int solution(int[] elements) {
        // 7 9 1 1 4
        // i는 부분 순열 길이 1 ~ 5
        int n = elements.length;
        int[] arr = new int[n * 2];
        
        // 배열 2배로 만들기
        for (int i = 0; i < n * 2; i++) {
            arr[i] = elements[i % n];
        }
        
        Set<Integer> set = new HashSet<>();
        for (int len = 1; len <= n; len++){
            for(int start = 0; start < n; start++){
                // 0부터 i만큼의 길이의 합을 구해서 set에 넣기
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += arr[start + k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}