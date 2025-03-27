class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        if(a % 2 != 0 && b % 2 != 0){
            answer = a * a  + b * b;
        }
        else if(a % 2 != 0 || b % 2 != 0){
            answer = (a + b) * 2;
        }        
        
        else{
            answer = a - b;
            if(answer < 0){
                answer = answer * -1;
            }
        }
        return answer;
    }
}