import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        // 컨테이너 1 ~ n까지 번호 증가 순 그리고 앞에서 부터 꺼내야함
        Queue<Integer> con = new LinkedList<>();
        // 보조는 마지막에 들어온걸 먼저 뺼 수 있음
        Stack<Integer> sub = new Stack<>();
        
        // 일단 n까지 다 넣어놓기
        for(int i = 1; i <= n; i++){con.offer(i);}
        
        // 그리고 이제 order에 맞는 값이 있으면 꺼내기
        for(int i = 0; i < n; i++){
            boolean check = false;
            int num = order[i];
            // 꺼내서 보관한 sub에 있는지
            if(!sub.isEmpty() && sub.peek() == num){
                answer++;
                sub.pop();
                check = true;
            }
            // 꺼낸게 기존 con에 있는지
            else{
                while(!con.isEmpty()){
                    int c = con.poll();
                    if(c == num){answer++; check= true; break;}
                    else{sub.push(c);}
                }
            }
            if(!check){break;}
        }
        
        return answer;
    }
}