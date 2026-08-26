import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // map을 통해서 각 범위 안에서 몇개씩 들어있는지 비교
        // 그리고 하나씩꺼내서 비교했을 떄 number를 만족하지 못하면 continue        
        // 시작점을 0부터 하고 9까지 갈 수 있는 범위를 정하기
        int len = discount.length;
        int answer = 0;
        for(int start = 0; start < len - 9; start++){
            Map<String, Integer> map = new HashMap<>();
            for(int i = start; i < start + 10; i++){
                String d = discount[i];
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            
            boolean check = true;
            for(int j = 0; j < want.length; j++){
                String w = want[j];
                int n = number[j];
                if(map.get(w) == null || map.get(w) != n) { check = false; break; }
            }
            
            if(check) answer++;
        }
        return answer;
    }
}