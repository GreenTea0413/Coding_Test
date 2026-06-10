class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int rest = storey % 10;
            
            if(rest > 5){
                answer += 10 - rest;
                storey = (storey / 10) + 1;
            }
            else if(rest < 5){
                answer += rest;
                storey = (storey / 10);
            }
            // 5일때는 앞자리 보고 내리던지 올리던지 해야함
            else{
                int front = (storey / 10) % 10;
                if(front >= 5){
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