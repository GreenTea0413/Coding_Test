import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            else if(c == ')'){
                if(!stack.isEmpty()) stack.pop();  
                else return false;
            }
        }
        
        if(stack.size() > 0) return false;
        return answer;
    }
}
