import java.util.*;

class Solution {
    public int solution(int[] a) {
        int len = a.length;
        if(len == 1) return 0;
        
        // 배열에 있는 숫자들 갯수를 map에다가 담아서 체크하기 -> 교집합 원소 1개 비교 가능
        // 5 2 3 3 5 3 -> [5 2 5 3]
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        
        int answer = 0;
        for(int key : map.keySet()){
            if(answer >= map.get(key)) continue;
            int count = 0;
            
            for(int i = 0; i < len - 1; i++){
                if((a[i] == key || a[i + 1] == key) && a[i] != a[i + 1]){
                    count++;
                    i++;
                }
            }
            answer = Math.max(count, answer);
        }
        
        return answer * 2;
    }
}