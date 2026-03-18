import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int[] arr = new int[len * 2];
        for(int i = 0; i < len * 2; i ++){
            arr[i] = elements[i % len];
        }
        
        Set<Integer> answer = new HashSet<>();
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < len; j++){
                int sum = 0;
                for(int start = j; start < j + i; start++){
                    sum += arr[start];
                }
                answer.add(sum);
            }
        }
        
        
        return answer.size();
    }
}