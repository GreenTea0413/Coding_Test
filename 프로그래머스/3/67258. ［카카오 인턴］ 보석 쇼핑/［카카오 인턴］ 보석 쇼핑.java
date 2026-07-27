import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[1] = gems.length;
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){set.add(gems[i]);}
        
        if(set.size() == 1) return new int[]{1, 1};
        int kind = set.size();
        int left = 0;
        int right = 0;
        Map<String, Integer> map = new HashMap<>();
        
        while(right < gems.length){
            String g = gems[right];
            map.put(g, map.getOrDefault(g, 0) +1);
            
            // 만약에 map크기가 이제 kind랑 맞으면
            while(map.size() == kind){
                // 그리고 가장 짧은 구간이니까
                if((answer[1] - answer[0]) > (right - left)){
                    answer[0] = left;
                    answer[1] = right;
                }
                 String l = gems[left];
                map.put(l, map.get(l) - 1);
                if(map.get(l) == 0) map.remove(l);
                left++;
            }
            
            right++;
        }
        answer[0] ++;
        answer[1] ++;
        return answer;
    }
}