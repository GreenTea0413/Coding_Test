import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int len = plans.length;
        String[] answer = new String[len];
        Arrays.sort(plans, (a, b) -> (a[1].compareTo(b[1])));
        
        // 하고 있는 과제는 바로 스택에 멈추기
        Stack<String[]> stack = new Stack<>();
        // 큐에 순서대로 과제들 넣어놓기
        Queue<String[]> q = new LinkedList<>();
        for(String[] p : plans) q.offer(p);
        
        int idx = 0;
        // 작업 시작
        while(!q.isEmpty()){
            // 하나 꺼내기
            String[] plan = q.poll();
            int start = min(plan[1]);
            int time = Integer.parseInt(plan[2]);
            
            // 다음 작업까지 시간이 얼마나 차이가 나는가
            int nextStart = !q.isEmpty() ? min(q.peek()[1]) : Integer.MAX_VALUE;
            int remain = nextStart - (start + time);
            
            // 만약에 남는 시간안에 끝난다? 그러면 바로 정답에 넣기
            if(remain >= 0){
                answer[idx] = plan[0];
                idx++;
                
                // 근데 만약에 stack에 남은 작업 중에서도 이 남은시간안에 작업할 수 있으면
                while(!stack.isEmpty() && remain > 0){
                    String[] now = stack.pop();
                    int n = Integer.parseInt(now[1]);
                    
                    if(remain - n >= 0) {
                        answer[idx] = now[0];
                        remain -= n;
                        idx++;
                    }
                    else{
                        stack.push(new String[]{now[0], String.valueOf(n - remain)});
                        break;
                    }
                }
                
                
            }
            // 만약에 시간안에 못끝낸다?
            else{
                // 기존 작업의 남은 시간
                int gap = time - (nextStart - start);
                stack.push(new String[]{plan[0], String.valueOf(gap)});
            }
        }
        
        return answer;
    }
    
    int min(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}