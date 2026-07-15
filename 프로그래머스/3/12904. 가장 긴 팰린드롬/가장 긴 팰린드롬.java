class Solution
{
    public int solution(String s){
        int answer = 0;
        // 우선 짝수와 홀수의 경우가 있음
        for(int i = 0; i < s.length(); i++){
            answer = Math.max(answer, palindrome(s,i,i));
            answer = Math.max(answer, palindrome(s,i,i + 1));
        }
        
        return answer;
    }
    
    // 이걸로 처음에 0, 1이 오게되면 left와 right를 늘려가면서 비교
    // 사실상 i가 0이면 0, 1이 끝
    // i가 1이면 0,1,2 또는 0, 1, 2, 3이끝
    int palindrome(String s, int left, int right){
        while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}