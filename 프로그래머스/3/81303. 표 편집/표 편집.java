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

        Stack<Integer> removed = new Stack<>();
        int cur = k;
        for(String s : cmd){

            char op = s.charAt(0);

            if(op == 'U'){
                int x = Integer.parseInt(s.split(" ")[1]);

                while(x-- > 0){
                    cur = prev[cur];
                }
            }

            else if(op == 'D'){
                int x = Integer.parseInt(s.split(" ")[1]);

                while(x-- > 0){
                    cur = next[cur];
                }
            }

            else if(op == 'C'){
                removed.push(cur);

                int p = prev[cur];
                int nNode = next[cur];

                if(p != -1) next[p] = nNode;
                if(nNode != -1) prev[nNode] = p;

                if(nNode != -1){
                    cur = nNode;
                }else{
                    cur = p;
                }
            }

            else{
                int restore = removed.pop();

                int p = prev[restore];
                int nNode = next[restore];

                if(p != -1) next[p] = restore;
                if(nNode != -1) prev[nNode] = restore;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        while(!removed.isEmpty()){
            answer[removed.pop()] = 'X';
        }

        return String.valueOf(answer);
    }
}