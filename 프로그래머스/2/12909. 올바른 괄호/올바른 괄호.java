import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
            }
        }
        
        if(stack.size() > 0) return false;
        return true;
    }
}