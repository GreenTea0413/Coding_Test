import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        
        // 삭제된 곳의 prev, 삭제된 곳, 삭제된 곳의 next
        Stack<int[]> stack = new Stack<>();
        int now = k;
        for(String c : cmd){
            String[] s = c.split(" ");
            // C, Z
            if(s.length == 1){
                if(s[0].equals("C")) {
                    // 삭제할 때 stack에다가 보관해야함
                    // 2 3 4에서 3 삭제할 때 2는 4를 가르키고 4는 2를 가르켜야함
                    stack.push(new int[]{prev[now], now, next[now]});
                    if(prev[now] != -1) next[prev[now]] = next[now];
                    if(next[now] != -1) prev[next[now]] = prev[now];
                    
                    // 그리고 아래로 가야하는데 삭제했으니까 앞뒤로 연결 끊어줘야함
                    if(next[now] == - 1) now = prev[now];
                    else now = next[now];
                }
                else {
                    // 0 1 2 4 5 6에서 원래 3을 다시 불러오면
                    // next[2] = 3
                    // prev[4] = 3
                    // [2,3,4]
                    int[] restore = stack.pop();
                    
                    if (restore[0] != -1) next[restore[0]] = restore[1];
                    if (restore[2] != -1) prev[restore[2]] = restore[1];
                }
            }
            else{
                int x = Integer.parseInt(s[1]);
                
                if(s[0].equals("U")) for(int i = 0; i < x; i++) now = prev[now];
                else for(int i = 0; i < x; i++) now = next[now];
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) answer.append("O");
        while(!stack.isEmpty()){
            int[] s = stack.pop();
            answer.setCharAt(s[1], 'X');
        }
        return answer.toString();
    }
}