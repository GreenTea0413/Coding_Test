class Solution
{
    public int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            left--;
            right ++;
        }
        return right - left - 1;
    }
    
    public int solution(String s)
    {
        int answer = 0;
        int len = s.length();
        for (int i = 0; i < len; i ++){
            answer = Math.max(answer, expand(s,i,i));
            answer = Math.max(answer, expand(s,i,i+1));
        }
        return answer;
    }
}