class Solution{
    int len;
    public int solution(String s){
        int answer = 0;
        len = s.length();
        for(int i = 0; i < len; i++){
            answer = Math.max(answer, Math.max(palindrome(s, i, i), palindrome(s, i, i + 1)));
        }
        return answer;
    }
    
    int palindrome(String s, int left, int right){
        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        // 이렇게가면 0과 6일때 같아서 -> -1과 7이 되어버림
        return right - left - 1;
    }
}