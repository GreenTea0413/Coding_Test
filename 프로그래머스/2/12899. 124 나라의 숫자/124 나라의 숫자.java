class Solution {
    public String solution(int n) {
        String answer = "";
        
        while(n > 0){
            int r = n % 3;
            
            if(r == 0){
                answer = "4" + answer;
                n = n / 3 - 1;
            }
            else if (r == 1){
                answer = "1" + answer;
                n = n / 3;
            }
            else {
                answer = "2" + answer;
                n = n / 3;
            }
        }
        
        return answer;
    }
}