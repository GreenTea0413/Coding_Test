import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] str = msg.split("");
        
        // 1부터 26까지 미리 만들어놓기
        for (int i = 0; i < 26; i++){
            String next = String.valueOf((char)('A' + i)); 
            map.put(next, i + 1);
        }
        
        int idx = 0;
        int lastIdx = 27;
        
        while(idx < str.length){
            String next = str[idx];
            
            while(idx + 1 < str.length && map.containsKey(next + str[idx + 1])){
                next += str[idx + 1];
                idx++;
            }
            
            if(map.containsKey(next)){answer.add(map.get(next));}
            if(idx + 1 < str.length){
                map.put(next + str[idx + 1], lastIdx);
                lastIdx++;
            }
            
            idx++;
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}