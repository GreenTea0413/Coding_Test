import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> s = new Stack<>();
        
        // 1 2 3 -> 2 들어갈때 3 > 2 되니까 3을 비교해야하네
        // [0,0,1,0,0];
        // 0, 1, 3 -> 4 들어갈 때 가격 안떨어지니까 그대로 [0,1,3,4]
        for(int i = 0; i < len; i++){
            while(!s.isEmpty() && prices[s.peek()] > prices[i]){
                int idx = s.pop();
                answer[idx] = i - idx;
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int idx = s.pop();
            answer[idx] = len - idx - 1;
        }
        return answer;
    }
}