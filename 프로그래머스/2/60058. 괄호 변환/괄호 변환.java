import java.util.*;

class Solution {
    public String solution(String p) {
        if(p.equals("")) return "";
        String answer = "";
        
        // '(' 와 ')' 의 개수는 항상 같습니다.
        // 그러면 처음에 ( 과 )의 수를 세서 같으면 짤라내기? 어차피 얘네는 뭘 해도 상관없으니까
        // 그리고 일단 갯수만 먼저 맞추면 올바르다고 판단하는듯
        int left = 0;
        int right = 0;
        int idx = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') left++;
            else right++;
            
            if(left == right) {
                idx = i;
                break;
            }
        }
        
        // 여기서 이제 ( ) 이거 서로 수 맞춰줬으니까 잘라
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        
        // u 가 이제 올바른지 판단해야함
        // 맞음녀 v만 다시 돌리라고 함
        // 근데 아니면 앞에 ( + V +)로 돌려야함
        if(check(u)) return u + solution(v);
        
        String next = "(" + solution(v) + ")";
        
        StringBuilder sb = new StringBuilder();
        // 그리고 u의 첫번째와 마지막을 제거하고 나머지는 다 뒤집어서 넣고
        // 그거를 next뒤에 붙이기
        for(int i = 1; i < u.length() - 1; i++){
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        
        return next + sb.toString();
    }
    
    boolean check(String u){
        // 여기서 확인하기
        Stack<Character> stack = new Stack<>();
        
        for(char c : u.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty()) return false;
                else if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
            }
            else stack.push('(');
        }
        return true;
    }
}