import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : a){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) * 2 <= answer) continue;
            
            int pair = 0;
            for(int i = 0; i < len - 1; i++){
                // 2개씩 끊어야함
                if(a[i] != key && a[i + 1] != key) continue;
                if(a[i] == a[i + 1]) continue;
                
                pair++;
                i++;
            }
            answer = Math.max(answer, pair * 2);
        }
        
        return answer;
    }
}