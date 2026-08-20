import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        if(len == 1) return 0;
        
        // 여기에 Key값을 넣어서
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : a) map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(int key : map.keySet()){
            if(map.get(key) <= answer) continue;
            
            int count = 0;
            for(int i = 0; i < len - 1; i++){
                if((a[i] == key || a[i + 1] == key) && a[i] != a[i + 1]){
                    count ++;
                    i ++;
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer * 2;
    }
}