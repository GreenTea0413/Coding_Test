class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            answer = Math.max(answer, palindrome(s, i, i));
            answer = Math.max(answer, palindrome(s, i, i + 1));
        }
        return answer;
    }
    
    public int palindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        
        return right - left - 1;
    }
}