import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] answer = new int[temperatures.length];
        Deque <Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i ++){
            while(!stack.isEmpty()){
                int j = stack.peek();
                // 일단 i가 지금 가지고 있는 위치
                // j가 스택에 담아놨다가 꺼내서 보는 위치
                if(temperatures[i] > temperatures[j]){
                    answer[j] = i - j;
                    stack.pop();
                }else {
                    break;
                }
            }
            stack.push(i);
        }
        return answer;
    }
}