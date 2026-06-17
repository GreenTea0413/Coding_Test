class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = 0;
        for(int t : times){
            right = Math.max(t, right);
        }
        right *= n;
        
        long answer = right;
        
        while(left <= right){
            long mid = (left + right) /  2;
            long total = 0; // 나눈 수 30 / 7 -> 4 + 30 / 10 -> 3 가져가는 느낌
            for(int t : times){
                total += mid / t;
            }
            
            if(total < n){
                left = mid + 1;
            }
            else{
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}