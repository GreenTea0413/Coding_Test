import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // U 2 는 2번 위로가서 행을 선택
        // D 2 는 2번 밑으로 내려가서 선택
        // C는 현재 행 삭제, 아래 행 선택 -> 만약에 n - 1 번째일 때 삭제하면 위치는 0
        // Z는 삭제한것만 되돌림
        int location = k;
        Stack<int[]> stack = new Stack<>(); // [위치, 앞의값, 뒤의값]
        
        // 모든 계산을 다 하면 시간초과 발생함
        // 그래서 node 처럼 만들어서 앞뒤로 이어지게 한 다음 다음 목적지로 바로 이동하도록 하기
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        next[n - 1] = -1;
        
        for(String c : cmd){
            if(c.length() > 1){
                String[] arr = c.split(" ");
                int num = Integer.parseInt(arr[1]);
                if(arr[0].equals("U")){
                    while(num > 0){
                        num --;
                        location = prev[location];
                    }
                }
                else if(arr[0].equals("D")){
                    while(num > 0){
                        num --;
                        location = next[location];
                    }
                }
            }
            else {
                if(c.equals("Z")){
                    if(!stack.isEmpty()){
                        int[] restore = stack.pop();

                        int idx = restore[0];
                        int p = restore[1];
                        int nIdx = restore[2];

                        if (p != -1) {
                            next[p] = idx;
                        }
                        if (nIdx != -1) {
                            prev[nIdx] = idx;
                        }
                    }
                }
                else if(c.equals("C")){
                    stack.push(new int[]{location, prev[location], next[location]});
                    
                    if(prev[location] != -1){next[prev[location]] = next[location];}
                    if(next[location] != -1){prev[next[location]] = prev[location];}
                    
                    if(next[location] != -1){location = next[location];}
                    else{location = prev[location];}
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){answer.append('O');}
        for(int[] s : stack){
            answer.setCharAt(s[0], 'X');
        }
        return answer.toString();
    }
}