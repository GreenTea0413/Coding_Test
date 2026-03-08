class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String number = "";
        
        int num = 0;
        // m * t 글자 이상 만들기
        while (number.length() < m * t) {
            number += toN(num, n);
            num++;
        }
        
        // p번째 사람 위치: 인덱스 p-1부터 m 간격으로 t개
        for (int i = p - 1; i < m * t; i += m) {
            answer += number.charAt(i);
        }
        
        return answer.toUpperCase();
    }
    
    public String toN(int num, int n) {
        if (num == 0) return "0";

        String res = "";
        while (num > 0) {
            int r = num % n;
            // 둘 다 char나 String으로 통일
            char c = r >= 10 ? (char)('A' + r - 10) : (char)('0' + r);
            res = c + res;
            num /= n;
        }
        return res;
    }
}