import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        
        // n번까지 증가하는 순서
        // 메인 컨테이너여서 1 ~ n까지 이미 실려있음
        Queue<Integer> main = new LinkedList<>();
        for(int i = 1; i <= n; i++) main.offer(i);
        
        // 보조는 막혀있어서 젤 위에꺼만 뺼 수 있음
        // stack 써야함
        Stack<Integer> sub = new Stack<>();
        
        for(int o : order){
            boolean check = false;
            // 보조에서 꺼낼 수 있으면 먼저 꺼내기
            if(!sub.isEmpty() && sub.peek() == o) {
                sub.pop();
                answer++;
                check = true;
            }
            else{
                // 보조에서 없으니까 이제 메인에서 하나씩 꺼내보기
                while(!check && !main.isEmpty()){
                    int now = main.poll();
                    if(now == o) {
                        answer++;
                        check = true;
                        break;
                    }
                    else sub.push(now);
                }   
            }
            
            if(!check) break;
        }
        
        return answer;
    }
}