class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 1;
        int right = 1;
        int num = 0;
        
        while(left <= n){
            if(num < n) {
                num += right;
                right++;
            }
            
            else if(num > n) {
                num -= left;
                left ++;
            }
            
            else if(num == n) {
                answer ++;
                num -= left;
                left ++;
            }
        }
        return answer;
    }
}