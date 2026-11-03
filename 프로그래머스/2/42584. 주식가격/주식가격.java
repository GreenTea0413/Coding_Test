import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[l];
        
        // 스택에다가 값을 넣는데 만약에 방금 넣은거랑 지금 넣을거랑 비교해서 방금 넣은게 더 크면 얘는 떨어진거니까 바로 내보내야함 
        // 근데 이걸 값을 스택에 넣으면 구분하기 힘드니까 idx를 넣어서 비교하기
        // i가 3일 때 q에 0,1,2가 있는데 prices[2] > now보다 큼 (3 > 2)
        // 그러면 나와서 가격 떨어진 시간을 넣어주면 됨
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < l; i++){            
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i] ){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = l - idx - 1;
        }
        return answer;
    }
}