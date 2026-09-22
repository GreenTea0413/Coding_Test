class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(!check(mid, stones, k)) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return right;
    }
    
    boolean check(int n, int[] stones, int k){
        int count = 0;
        // count를 0으로 두고 
        for(int i = 0; i < stones.length; i++){
            if(stones[i] < n){
                count++;
            }
            else{
                count = 0;
            }
            
            if(count >= k){
                return false;
            }
        }
        return true;
    }
}