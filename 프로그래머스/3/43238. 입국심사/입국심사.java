class Solution {
    public long solution(int n, int[] times) {
        int max = 0;
        for(int t : times) max = Math.max(max, t);
        
        long left = 1;
        long right = (long) max * n;
        long answer = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            
            long sum = 0;
            for(int t : times){
                sum += (mid / t);
            }
            
            if(sum >= n) {
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return answer;
    }
}