import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i : nums){
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }
        
        int s = hash.size();
        if (count / 2 < s){
            answer = count / 2;
        }else {
            answer = s;
        }
        
        
        return answer;
    }
}