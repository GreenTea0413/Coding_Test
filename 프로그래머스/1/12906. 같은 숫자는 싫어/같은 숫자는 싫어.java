import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int a : arr){
            while(!stack.isEmpty() && stack.peek() == a){
                stack.pop();
            }
            stack.push(a);
        }       
        
        int[] answer = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}