import java.util.*;
class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (!stack.isEmpty() && c == stack.peek()) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty() ?  1: 0;
    }
}