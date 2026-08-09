import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        next[n - 1] = -1;
        int loc = k;
        for(String c : cmd){
            String[] s = c.split(" ");
            if(s.length > 1){
                int x = Integer.parseInt(s[1]);
                if(s[0].equals("U")){
                    while(x > 0){
                        loc = prev[loc];
                        x--;
                    }
                }
                else if(s[0].equals("D")){
                    while(x > 0){
                        loc = next[loc];
                        x--;
                    }
                }
            }
            else{   
                if(s[0].equals("C")){
                    // loc = 1
                    // 1이 이전에 가리키고 있는 곳에 다가 또 거기에 값을 새롭게 넣어줘야함
                    stack.push(new int[]{loc, prev[loc], next[loc]});

                    // 1앞이 만약에 아무것도 없는게 아니라면
                    // 1이 앞을 가리키고 있는 곳의 next가 1의 next가 되어야함
                    // 1이 뒤를 가리키고 있는 곳의 prev가 1의 prev를 가르켜야함
                    // 0 1 2 3 4
                    // 0 -> 2
                    // 0 <- 2
                    if(prev[loc] != -1) next[prev[loc]] = next[loc];
                    if(next[loc] != -1) prev[next[loc]] = prev[loc];

                    if(next[loc] == -1) loc = prev[loc];
                    else loc = next[loc];
                }
                else{
                    if(!stack.isEmpty()){
                        int[] now = stack.pop();

                        int l = now[0];
                        int pIdx = now[1];
                        int nIdx = now[2];
                        
                        if(pIdx != -1) next[pIdx] = l;
                        if(nIdx != -1) prev[nIdx] = l;
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) answer.append('O');
        for(int[] s : stack) answer.setCharAt(s[0], 'X');
        
        return answer.toString();
    }
}
