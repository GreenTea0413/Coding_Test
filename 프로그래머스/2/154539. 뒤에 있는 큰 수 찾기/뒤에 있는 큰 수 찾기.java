import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && stack.peek()[0] < numbers[i]){
                int[] out = stack.pop();
                answer[out[1]] = numbers[i];
            }
            
            stack.push(new int[]{numbers[i], i});
        }
        
        while(!stack.isEmpty()){
            int[] out = stack.pop();
            answer[out[1]] = -1;
        }
        
        return answer;
    }
}