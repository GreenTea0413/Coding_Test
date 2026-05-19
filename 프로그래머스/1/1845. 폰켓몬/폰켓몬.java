import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        if(map.size() > n){return n;}
        else {return map.size();}
    }
}