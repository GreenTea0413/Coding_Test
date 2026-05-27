import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        if(len % 2 == 1) return 0;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < len; i++){
            String temp = s.substring(i,len) + s.substring(0,i);
            int count = 0;
            for(char c : temp.toCharArray()){
                if(c == '{' || c == '(' || c == '['){
                    stack.push(c);
                }            
                else{
                    if(stack.isEmpty()) break;
                    
                    if(c == '}'){
                        if(stack.peek() == '{') {stack.pop(); count++;}
                        else {break;}
                    }
                    else if(c == ']'){
                        if(stack.peek() == '[') {stack.pop(); count++;}
                        else {break;}
                    }
                    else if(c == ')'){
                        if(stack.peek() == '(') {stack.pop(); count++;}
                        else {break;}
                    }
                    
                }
            }
            
            if(count == len / 2){answer++;}
        }
        return answer;
    }
}