import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int len = elements.length;
        int[] copy = new int[len * 2];
        
        for(int i = 0; i < len * 2; i++){
            copy[i] = elements[i % len];
        }
        
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < len; j++){
                int sum = 0;
                for(int k = j; k < j + i; k++){
                    sum += copy[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}