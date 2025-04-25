import java.util.*; 
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counts = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        // 일단 progresses 안에서 값들을 하나씩 꺼내서 100 >= 을 만드는데 걸리는 일 수를
        // 다른 배열에 저장
        // 그리고 배열에서 정렬 후 같은 숫자인 갯수만큼 answer배열에 넣어서 나오게하기
        
        for(int i = 0; i < progresses.length; i++){
            // 나눈 몫이 더 크면 일단 하루 +1 더 해줘야함
            if((100 - progresses[i]) % speeds[i] != 0){
               queue.add((int) (100 - progresses[i]) / speeds[i] + 1);
                //System.out.print((100 - progresses[i]) / speeds[i] + 1 + "  ");
            }
            else{
                queue.add((int) (100 - progresses[i]) / speeds[i]);
                //System.out.print((100 - progresses[i]) / speeds[i] + "  ");
            }
        }
    
        while (!queue.isEmpty()) {
	        // 제일 첫번 째 요소 뽑기
            int current = queue.remove();
          	// 배포 작업 개수 1로 설정
            int count = 1;
            
          	// 큐의 맨 위 요소가 자신보다 작은 동안 요소를 제거하고 작업 개수를 + 1
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.remove();
                count++;
            }
          	//작업 개수를 리스트에 저장
            counts.add(count);
        }
        
        // 작업 개수를 반환
        int[] answer = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++) {
            answer[i] = counts.get(i);
        }
        return answer;
    }
}