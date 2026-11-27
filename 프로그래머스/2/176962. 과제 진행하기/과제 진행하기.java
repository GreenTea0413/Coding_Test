import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        // 진행중이면 종료하고 새로 들어온거 시작
        // 가장 최근에 멈춘거 부터니까 stack이고 과목 이름이랑 남은 시간만 체크하면 됨
        Stack<String[]> stack = new Stack<>();
        
        // 그리고 시작 순서에 맞게 배열 맞추기
        Arrays.sort(plans, (a, b) -> {return a[1].compareTo(b[1]);});
        int idx = 0;
        int len = plans.length;
        
        while(idx < len){
            String[] now = plans[idx];
            int start = toNum(now[1]);
            
            int nextStart = idx + 1 == len ? Integer.MAX_VALUE :toNum(plans[idx + 1][1]);
            int rest = nextStart - start;
            
            int time = Integer.parseInt(now[2]);
            
            if(rest >= time) {
                answer.add(now[0]);
                rest -= time;
                while(rest > 0 && !stack.isEmpty()){
                    String[] work = stack.pop();

                    if(rest - Integer.parseInt(work[1]) >= 0){
                        answer.add(work[0]);
                        rest -= Integer.parseInt(work[1]);
                    }
                    else{
                        stack.push(new String[]{work[0], 
                                    String.valueOf(Integer.parseInt(work[1]) - rest)});
                        rest = 0;
                    }
                }
            }
            else{
                stack.push(new String[]{now[0], String.valueOf(time - rest)});
            }
            
            idx++;
        }
        
        return answer.toArray(new String[0]);
    }
    
    int toNum(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}