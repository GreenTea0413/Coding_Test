import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int len = gems.length;
        int gap = len;
        Set<String> set = new HashSet<>();
        for(String g : gems) set.add(g);

        Map<String, Integer> map = new HashMap<>();
        while(right < len){
            String g = gems[right];
            map.put(g, map.getOrDefault(g, 0) + 1);
            
            while(map.size() == set.size()){
                if(gap > right - left) {
                    gap = right - left;
                    answer[0] = left + 1; answer[1] = right + 1;
                }
                String lGem = gems[left];
                map.put(lGem, map.get(lGem) - 1);
                if(map.get(lGem) == 0) map.remove(lGem);
                left++;
            }
            right++;
        }
        return answer;
    }
}