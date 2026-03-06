import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // 메인 - 맨 앞에 놓인 상자를 트럭에 실어야하는데 번호가 다르면 보조로 감
        // 보조 - 맨 위에서 꺼냄
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int len = order.length;
        
        for(int i = 1 ; i <= len; i++){
            queue.offer(i);
        }
        
        for(int i = 0; i < len; i++){
            boolean check = false;
            // 보조 확인
            if(stack.size() >= 1 && stack.peek() == order[i]) {
                answer++;
                stack.pop();
                check = true;
            }
            // 메인 확인
            else{
                while(!queue.isEmpty()){
                    int num = queue.poll();
                    if(num == order[i]){
                        answer++;
                        check = true;
                        break;
                    }
                    else{
                        stack.push(num);
                    }
                }
            }
            if(!check) {break;}
        }
        
        return answer;
    }
}