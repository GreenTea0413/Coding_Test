import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        // 스택에는 [값, 인덱스]를 넣기
        Stack<int[]> stack = new Stack<>();
        
        // 스택에 이제 값을 넣은건데 넣기전에 이전에 있던 값이랑 비교하기 
        for(int i = 0; i < len; i++) {
            // 처음에 없으니까 바로 2,0 들어감
            // 그러고 나서 3,1이 오는데 어라? 2보다 더 크네?
            // 그럼 바로 빼내서 answer[0]은 지금 더 큰 값이 들어가는거임. 그리고 3,1은 스택으로
            // 이거 무한반복
            while(!stack.isEmpty() && stack.peek()[0] < numbers[i]){
                int[] now = stack.pop();
                answer[now[1]] = numbers[i];
            }
            
            stack.push(new int[]{numbers[i], i});
        }
        
        // 계속 커서 남아있는 것들을 이제 빼서 -1 넣어주는거임!
        while(!stack.isEmpty()){
            int[] now = stack.pop();
            answer[now[1]] = -1;
        }
        
        return answer;
    }
}