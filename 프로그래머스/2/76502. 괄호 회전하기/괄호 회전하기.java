import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        if (len % 2 == 1) return 0;
        
        String[] arr = new String[len * 2];
        for(int i = 0; i < len * 2; i++){
            arr[i] = String.valueOf(s.charAt(i % len));
        }
        
        for (int start = 0; start < len; start++){
            Stack<String> stack = new Stack<>();
            int count = 0;
            for(int i = start; i < start + len; i++){
                String next = arr[i];
                
                if(next.equals("[") || next.equals("(") || next.equals("{")){
                    stack.push(next);
                }
                
                else {
                    if (stack.isEmpty()) {break;}
                    String word = stack.pop();
                    if (next.equals("]")){
                        if (word.equals("[")){
                            count ++;
                        }
                        else{
                            break;
                        }
                    }
                    if (next.equals("}")){
                        if (word.equals("{")){
                            count++;
                        }
                        else{
                            break;
                        }
                    }
                    if (next.equals(")")){
                        if (word.equals("(")){
                            count++;
                        }
                        else{break;}
                    }
                }
            }
            if (count == len / 2) {answer++;}
        }
        
        return answer;
    }
}