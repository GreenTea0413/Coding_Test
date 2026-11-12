import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int len = order.length;
            
        for(int i = 1; i <= len; i++) q.offer(i);
        
        // 중간에 한번이라도 스택이랑 큐에서 둘다 못찾으면 바로 아웃!
        for(int o : order){
            boolean check = false;
            if(!stack.isEmpty() && stack.peek() == o){
                stack.pop();
                answer++;
                check = true;
            }
            else{
                while(!q.isEmpty()){
                    int n = q.poll();
                    
                    if(n == o) {
                        answer++;
                        check = true;
                        break;
                    }
                    
                    else{
                        stack.push(n);
                    }
                }
            }
            if(!check) break;
        }
        return answer;
    }
}