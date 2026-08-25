import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        
        int[] arr = new int[len * 2];
        for(int i = 0; i < len; i++){
            arr[i] = elements[i];
            arr[i + len] = elements[i];
        }
        
        // 범위 정해줌
        for(int i = 1; i <= len; i++){
            // 0 1 2 3 4 하나씩 돌도록 하기
            // i가 2가되면 이제 2개씩 돌고
            for(int j = 0; j < len; j++){
                int count = 0;
                for(int k = j; k < j + i; k++){
                    count += arr[k];
                }
                set.add(count);
            }
        }
        return set.size();
    }
}