class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 1, -1, 10, -10 처럼 엘리베이터에 대해서 딱 나눠 떨어지면 버튼 횟수를 줄일 수 있음
        while(storey > 0){
            int rest = storey % 10;
            // 나머지가 5보다 크면 10이랑 더 가까우니까 storey를 더해주기
            // 그리고 다음 자릿수로 가야하니까 /10으로 나눠주면 됨
            if(rest > 5) {
                answer += 10 - rest;
                storey = (storey / 10) + 1;
            }
            else if(rest < 5) {
                answer += rest;
                storey = (storey / 10);
            }
            // 예외로 만약에 5랑 같다면? 
            else{
                // 그럴 경우 95면 100으로 만드는게 훨씬 이득임
                // 그래서 앞자리를 알아야함
                // 95 / 10 % 10 이여서 나머지는 9;
                int front = (storey / 10) % 10;
                
                // 50이상이면 무조건 5 더하는게 이득
                if(front >= 5) {
                    answer += 5;
                    storey = (storey / 10) + 1;
                }
                else{
                    answer += 5;
                    storey = storey / 10;
                }
            }
        }
        return answer;
    }
}