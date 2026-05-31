import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<int[]> stack = new Stack<>();
        
        // [2,0] [3,1] 2 나오고 answer[0] = 3;
        // [3,1] [3,2]
        // [3,1] [3,2] 일 떄 numbers[3]가 오면 q.peek()[0] < numbers[3]
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && stack.peek()[0] < numbers[i]){
                int[] arr = stack.pop();
                answer[arr[1]] = numbers[i];
            }
            stack.push(new int[]{numbers[i], i});    
        }
        
        while(!stack.isEmpty()){
            int[] r = stack.pop();
            answer[r[1]] = -1;
        }
        return answer;
    }
}