import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        // 메인 컨테이너는 무조건 앞에서부터 꺼내기 (1부터 시작이고 값이 다르면 다 보조로 감)
        // 보조 컨테이너는 스택방식
        int len = order.length;
        Queue<Integer> q = new LinkedList<>(); for(int i = 0; i < len; i++) q.offer(i + 1);
        Stack<Integer> stack = new Stack<>();
        
        for(int o : order){
            boolean check = false;
            // 우선 보조에서 먼저 찾는다고 함
            if(!stack.isEmpty() && stack.peek() == o){
                stack.pop();
                answer++; 
                check = true;
            }
            // 그 다음 보조에서 없으면 메인에서 꺼내서 비교
            else{
                while(!q.isEmpty()){
                    int now = q.poll();
                    if(now == o) {
                        answer++;
                        check = true;
                        break;
                    }
                    else {
                        stack.push(now);
                    }
                }
            }
            
            if(!check) break;
        }
        
        return answer;
    }
}