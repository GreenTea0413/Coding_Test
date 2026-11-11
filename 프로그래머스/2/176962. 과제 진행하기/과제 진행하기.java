import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int len = plans.length;
        String[] answer = new String[len];
        Arrays.sort(plans, (a, b) -> (a[1].compareTo(b[1])));
        
        // 잠시 멈출것들 모으기 여긴 
        // 이름이랑 남는 시간만 쓰면 됨
        Stack<String[]> stack = new Stack<>();
        // 작업 순서대로 시작
        Queue<String[]> q = new LinkedList<>();
        
        for(int i = 0; i < len; i++) q.offer(plans[i]);
        int idx = 0;
        while(!q.isEmpty()){
            String[] plan = q.poll();
            int start = min(plan[1]);
            int time = Integer.parseInt(plan[2]);
            
            int nextStart = q.isEmpty() ? Integer.MAX_VALUE : min(q.peek()[1]);
            int gap = nextStart - start;
            
            // 바로 다음 작업보다 빨리 끝나면 종료!
            // 그리고 스택에 만약에 남아있는게 있다면
            if(time <= gap){
                answer[idx] = plan[0];
                idx++;
                int remain = gap - time;
                
                // 남는 시간동안 끝낼 수 멈춰놨던거 실행
                while(!stack.isEmpty() && remain > 0){
                    String[] stop = stack.pop();
                    int sTime = Integer.parseInt(stop[1]);
                     
                    if(sTime <= remain){
                        answer[idx] = stop[0];
                        idx++;
                        remain -= sTime;
                    }
                    else{
                        stop[1] = String.valueOf(sTime - remain);
                        stack.push(stop);
                        remain = 0;
                    }
                }
            }
            else{
                stack.push(new String[]{plan[0], String.valueOf(time - gap)});
            }
        }
        return answer;
    }
    
    int min (String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}