class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String number = "";
        int len = t * m;
        
        int num = 0;
        while(number.length() < len){
            number += toNum(num, n);
            num++;
        }
        
        for(int i = p - 1; i < len; i += m){
            answer += number.charAt(i);
        }
        
        return answer;
    }
    
    public String toNum(int num, int n){
        if (num == 0) return "0";
        
        String str = "";
        while(num > 0){
            int rest = num % n;
            char c = (rest >= 10) ? (char)('A' + rest - 10) : (char)('0' + rest);
            str = c + str;
            num /= n;
        }
        return str;
    }
}