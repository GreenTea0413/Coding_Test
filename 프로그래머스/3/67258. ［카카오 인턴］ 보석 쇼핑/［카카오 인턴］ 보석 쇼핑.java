import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String g : gems){set.add(g);}
        int count = set.size();
        if(count == 1) return new int[]{1,1};
        
        int len = gems.length;
        int[] answer = new int[]{0, len};
        int left = 0;
        int right = 0;
        Map<String, Integer> map = new HashMap<>();
        
        while(right < len){
            String g = gems[right];
            map.put(g, map.getOrDefault(g, 0) + 1);
            
            while(map.size() == count){
                if(answer[1] - answer[0] > right - left){
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0) map.remove(gems[left]);
                left++;
            }
            right++;
        }
        
        return answer;
    }
}