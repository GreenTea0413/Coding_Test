class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = 1;
        for(int t : times) right = Math.max(right, t);
        right = right * n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            if(check(n, times, mid)){
                right = mid - 1;
                answer = mid;
            }
            else left = mid + 1;
        }
        return answer;
    }
    
    boolean check(int n, int[] times, long mid){
        long count = 0;
        for(int i = 0; i < times.length; i++) {
            count += mid / times[i]; 
            if(count >= n) return true;
        }
        
        return false;
    }
}