import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        String[] num = number.split("");
        Stack<Integer> q = new Stack<>();
        
        for(String n : num){
            while(k > 0 && !q.isEmpty() && q.peek() < Integer.parseInt(n)){
                q.pop();
                k--;
            }
            q.push(Integer.parseInt(n));
        }
        
        
        for(int i = 0; i < k; i++){
            q.pop();
        }
        
        String temp = "";
        while(!q.isEmpty()){
            temp += String.valueOf(q.pop());
        }
        
        for(int i = temp.length() - 1; i >= 0; i--){
            answer += String.valueOf(temp.charAt(i));
        }
        return answer;
    }
}