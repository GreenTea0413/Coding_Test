import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int len =s.length();
        sb.append(s); sb.append(s);
        // sb에다가 s를 두번 합치기
        // 그리고 s의 길이만큼 범위를 정하고 0 ~ len까지 반복해서 올바르게 되는거 찾기
        for(int start = 0; start < len; start++){
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            
            // 문자 돌면서 여기서 하나씩 체크
            for(int i = start; i < start + len; i++){
                char c = sb.charAt(i);
                
                // ( [ { 이면 넣기
                // 들어갔는데 
                if(c == '(' || c == '{' || c == '[') stack.push(c);
                else{
                    if(c == ')'){
                        if(stack.isEmpty() || stack.peek() != '(') {check = false; break;}
                        else if(stack.peek() == '(') stack.pop();
                    }
                    if(c == ']'){
                        if(stack.isEmpty() || stack.peek() != '[') {check = false; break;}
                        else if(stack.peek() == '[') stack.pop();
                    }
                    if(c == '}'){
                        if(stack.isEmpty() || stack.peek() != '{') {check = false; break;}
                        else if(stack.peek() == '{') stack.pop();
                    }
                }
            }
            if(check && stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}