import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 일단 보석 종류 갯수 구하기
        Set<String> gem = new HashSet<>();
        for(String g : gems){gem.add(g);}
        int count = gem.size();
        if(count == 1) return new int[]{1,1};
        
        int left = 0;
        int right = 0;
        int len = gems.length;
        int[] answer = new int[]{0, len};
        
        // 보석 갯수 하나씩 채워넣기
        Map<String, Integer> map = new HashMap<>();
        
        while(right < len){
            String gr = gems[right];
            
            map.put(gr, map.getOrDefault(gr, 0) + 1);
            
            while(map.size() == count){
                String gl = gems[left];
                if(answer[1] - answer[0] > right - left){
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                map.put(gl, map.get(gl) - 1);
                if(map.get(gl) == 0) map.remove(gl);
                left++;
            }
            right++;
        }
        
        return answer;
    }
}