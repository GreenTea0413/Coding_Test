class Solution {
    public String solution(int n) {
        String answer = "";
        // 11 42 12 44 13 111
        while(n > 0){
            int rest = n % 3;
            
            if (rest == 0){
                answer = "4" + answer;
                n = n / 3 - 1;
            }
            else if(rest == 1){
                answer = "1" + answer;
                n /= 3;
            }
            else {
                answer = "2" + answer;
                n /= 3;
            }
        }
        return answer;
    }
}