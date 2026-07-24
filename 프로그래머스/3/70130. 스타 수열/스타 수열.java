import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        if(len < 2) return answer;
        
        // 이 문제는 해당 값을 얼마나 가지고 있고
        // 그 길이를 계속해서 늘려가면서 확인하는 문제
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : a){map.put(n, map.getOrDefault(n, 0) + 1);}
        
        // 키 하나씩 꺼내서 몇개 들어있는지 확인하고 그게 answer보다 작으면 패스
        // 그러지 않으면 for문을 돌려서 a배열 안에 값들이랑 
        for(int key : map.keySet()){
            if(map.get(key) <= answer) continue;
            
            int count = 0;
            for(int i = 0; i < len - 1; i++){
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