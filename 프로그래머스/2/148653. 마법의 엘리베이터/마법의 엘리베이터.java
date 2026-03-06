class Solution {
    public int solution(int storey) {
        int answer = 0;
        int temp = storey;
        int len = String.valueOf(storey).length();
        
        while(temp > 0){
            int rest = temp % 10;
            // 6이상이면
            if (10 - rest < rest) {
                temp = temp / 10 + 1;
                answer += 10 - rest;
            }
            // 4이하면
            else if(10 - rest > rest){
                temp = temp / 10;
                answer += rest;
            } 
            // 5일떄는 앞에 숫자 봐가면서 해야함
            else {
                int next = (temp / 10) % 10;
                if (next >= 5) {
                    temp = temp / 10 + 1;
                    answer += 5;
                }
                else {
                    temp = temp / 10;
                    answer += 5;
                } 
            }
        }
        return answer;
    }
}