import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        // 맵을 통해서 해당 숫자가 몇개 있는지 알아야함
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : a){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // 2개씩 묶어야함
        for(int key : map.keySet()){
            if(map.get(key) <= answer) continue;
            
            int count = 0;
            for(int i = 0; i < a.length - 1; i++){
                if((a[i] == key || a[i + 1] == key) && (a[i] != a[i + 1])){
                    count++;
                    i++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer * 2;
    }
}