import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        // 그러면 스택에 넣어놓고 최신값과 비교했을 때 줄어들었으면?
        // 빼내고 i위치에 맞게 갑승ㄹ answer에 넣어주기
        // 아 값을 넣는게 아니라 idx 값을 넣어야 뺀다음에 바로 적용가능함
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int num = stack.pop();
                answer[num] = i - num;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int n = stack.pop();
            answer[n] = len - n - 1;
        }
        return answer;
    }
}