import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        
        // 이걸 쭉 반복하면 딱봐도 터짐
        // 왼쪽은 0 부터 시작해서 하나씩 다 담아보면 됨
        // 오른쪽은 1부터 끝까지 다 담은 상태
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        left.put(topping[0], 1);
        for(int i = 1; i < len; i++){
            int t = topping[i];
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        for(int i = 1; i < len; i++){
            int t = topping[i];
            left.put(t, right.getOrDefault(t, 0) + 1);
            right.put(t, right.get(t) - 1);
            
            if(right.get(t) == 0) right.remove(t);
            if(left.size() == right.size()) answer++;
        }
        return answer;
    }
}