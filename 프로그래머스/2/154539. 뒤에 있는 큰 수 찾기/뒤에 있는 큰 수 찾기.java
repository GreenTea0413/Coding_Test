import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        // 이건 꼭 기억해야한다.. index 활용해서 다음 값 찾기
        Stack<Integer> stack = new Stack<>();
        for(int i = len -1; i >= 0; i--){
            int cur = numbers[i];
            
            while(!stack.isEmpty() && stack.peek() <= cur){
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(cur);
        }
        
        return answer;
    }
}