class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(!check(mid, k, stones)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }
    
    boolean check(long mid, int k, int[] stones){
        int count = 0;
        for(int i = 0; i < stones.length; i++){
            // 이게 못지나가니까 뛰어넘어야하는 곳
            if(stones[i] < mid) count++;
            else count = 0;
            
            if(count >= k) return false;
        }
        
        return true;
    }
}