class Solution {
    public String solution(int n) {
        String answer = "";
        if(n == 1) return "1";
        while(n > 0){
            n --;
            // 3으로 나누면 1, 2, 3 반복되게 해서 0이면 1 / 1 이면 2 / 2 이면 4
            int rest = n % 3;
            if(rest == 0) answer = "1" + answer;
            if(rest == 1) answer = "2" + answer;
            if(rest == 2) answer = "4" + answer;
            
            n = n / 3;
        }
        return answer;
    }
}