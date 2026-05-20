import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> q = new Stack<>();
        // 값 : 1 2 3 2 3
        // 인 : 0 1 2 3 4
        // 이러면 1,2,3 들어가고 2 들어갈 때(i가 3일때) 3보다 작기때문에 한번 q.poll발생
        // 3 - 2는 1인데..?
        // answer = [0,0,1,0,0]이 되어버림
        // 그리고 q는 이제 [0,1,3,4]가 되어버림
        for(int i = 0; i < len; i++){
            int p = prices[i];
            while(!q.isEmpty() && p < prices[q.peek()]){
                int idx = q.pop();
                answer[idx] = i - idx;  
            }
            q.push(i);
        }
        
        while(!q.isEmpty()){
            int n = q.pop();
            answer[n] = len - n - 1;
        }
        return answer;
    }
}