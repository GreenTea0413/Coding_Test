class Solution {
    public String solution(int n, int t, int m, int p) {
        // 미친건가? n진수 게임으로 이걸하네
        // 내차례때 말해야하는 값을 말해야함
        // 그러면 예를 들어 4번 말해야하고 사람이 2명이면 4턴가야함
        // n진수에 대해서 8글자까지 나오려면 0 1 10 11 100 여기까지 나와야함
        int len = m * t;
        int count = 1;
        
        String answer = "";
        String str = "0";
        
        while(str.length() < len){
            int num = count;
            String temp = "";
            while(num > 0){
                int rest = num % n;
                char c = (rest >= 10) ? (char)('A' + rest - 10) : (char) ('0' + rest);
                temp = c + temp;
                num = num / n;
            }
            str += temp;
            count++;
        }
        
        // 이제 여기서 str 완성되면 p번째 마다 말하도록 하기
        for(int i = p; i <= len; i += m){
            answer += "" + str.charAt(i - 1);
        }
        return answer;
    }
}