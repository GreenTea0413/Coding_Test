import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') stack.push(s.charAt(i));
            else{
                if (stack.isEmpty()) return false;
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        
        if (stack.size() > 0) return false;
        return true;
    }
}