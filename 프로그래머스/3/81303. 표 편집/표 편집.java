import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        
        // prev랑 next에 앞뒤로 인덱스 위치값 넣어주기
        // linkedList를 직접 만들어주는거임
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        int loc = k; // 현재 위치
        next[n - 1] = -1;
        Stack<int[]> stack = new Stack<>(); // 삭제한 행에 대해서 prev[idx], idx, next[idx] 담아서 복구 시키기
        for(String c : cmd){
            String[] s = c.split(" ");
            
            // 현재 윗칸을 선택할 때 단순하게 loc - 1이 아닌 현재 prev[next]가 가르키는 곳으로 위치를 옮기기
            if(s[0].equals("U")){
                int x = Integer.parseInt(s[1]);
                for(int i = 0; i < x; i++) loc = prev[loc];
            }
            else if(s[0].equals("D")){
                int x = Integer.parseInt(s[1]);
                for(int i = 0; i < x; i++) loc = next[loc];
            }
            // 행 삭제 loc에 대해서 loc이 원래 next[prev[loc]]과 prev[next[loc]]으로 이전값과 다음값이 연결되어있다면
            // 그 부분을 끊어내야함 1 2 3 4 5 / 2와 4는 원래 3을 가르키지만 이제 여기서 2는 4를 가르키고 4는 2를 가르켜야함
            else if(s[0].equals("C")){
                stack.add(new int[]{prev[loc], loc, next[loc]});
                
                if(prev[loc] != -1) next[prev[loc]] = next[loc];
                if(next[loc] != -1) prev[next[loc]] = prev[loc]; // 4의 이전값에 3의 이전값을 넣기
                
                if(next[loc] == -1) loc = prev[loc];
                else loc = next[loc];
            }
            // 그리고 복구니까 되돌려야함
            // 아까 3에 대해서 앞 뒤로 연결 해준거를 다시 삭제한 곳에 들어가도록 해야함
            else{
                if(!stack.isEmpty()){
                    int[] now = stack.pop();
                    // 2 3 4를 이제 다시 연결
                    
                    if(now[0] != -1) next[now[0]] = now[1];
                    if(now[2] != -1) prev[now[2]] = now[1];
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append('O');
        for(int[] s : stack) sb.setCharAt(s[1], 'X');
        return sb.toString();
    }
}