import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < len; i++){
            // 1 2 3 2 3
            // 1일 때는 그냥 stack 추가
            // 2일 때는 stack에다가 prices[idx = 0] > prices[i = 1]이 아니기에 근야 push
            // 3일 때도 그냥 push
            // 2일 때 prices[idx = 2] > prices[i = 3]이 맞음
            // i = 3일 때 그래서 한번 떨어짐
            // idx = 2 answer[2] = 3 - 2;
            // 하고 i를 다시 넣음
            // i = 4일 때는 
            // prices[idx = 3] > prices[i = 4]가 안되기 때문에 그냥 넘어감
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = len - idx - 1;
        }
        
        return answer;
    }
}