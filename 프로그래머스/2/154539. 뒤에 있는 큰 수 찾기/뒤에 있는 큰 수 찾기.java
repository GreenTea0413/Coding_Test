import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        // 2 3 3 5 -> 3 5 5 -1
        // len-2 부터 시작
        
        for(int i = len - 1; i >= 0; i--){
            // 현재 값
            int cur = numbers[i];
            // q에서 하나씩 꺼내서 이거보다 큰게 있는지 확인
            // q는 배열 뒤에서 부터 담기로 했음
            while(!stack.isEmpty() && numbers[stack.peek()] <= cur){      
                stack.pop();
            }
            
            answer[i] = stack.isEmpty() ? -1 : numbers[stack.peek()];
            
            stack.push(i);
        }
        return answer;
    }
}