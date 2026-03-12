import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        // 우선순위 큐로 과제 시작하는 순서대로 일단 정리
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        for(String[] plan : plans){pq.offer(plan);}
        
        // 이름, 남은 시간
        Stack<String[]> stack = new Stack<>();
        
        while(!pq.isEmpty()){
            String[] now = pq.poll();
            String name = now[0];
            int start = toMin(now[1]);
            int time = Integer.parseInt(now[2]);
            
            int nextStart = pq.isEmpty() ? Integer.MAX_VALUE : toMin(pq.peek()[1]);
            int gap = nextStart - start;
            
            // 과제하는 시간 + 시작시간이 다음 시작보다 빠르면
            if (time <= gap){
                // 과제 끝나는 거니까 일단 완료한거에 넣고
                // 남은 시간동안 stack에 있는거 꺼내서 얼만큼 할 수 있는지
                answer.add(name);
                int remain = gap - time;
                
                while(!stack.isEmpty() && remain > 0){
                    String[] s = stack.pop();
                    int sTime = Integer.parseInt(s[1]);
                    
                    // 남은시간 동안 할 수 있으면
                    if (sTime <= remain){
                        answer.add(s[0]);
                        remain -= sTime;
                    }
                    // 남는 시간 동안 못끝내면 일단 한거는 빼고 다시 stack에 넣기
                    else{
                        s[1] = String.valueOf(sTime - remain);
                        stack.push(s);
                        remain = 0;
                    }
                }
            }
            else{
                stack.push(new String[]{name, String.valueOf(time - gap)});
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    public int toMin(String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }
}