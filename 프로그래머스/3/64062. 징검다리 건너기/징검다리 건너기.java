class Solution {
    public int solution(int[] stones, int k) {
        int len = stones.length; 
        int left = 1;
        int right = 200000000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(isCheck(stones, k, mid)){left = mid + 1;}
            else{right = mid - 1;}
        }
        
        return right;
    }
    
    public boolean isCheck(int[] stones, int k, int mid){
        int count = 0;
        for(int s : stones){
            if(s - mid < 0) count++;
            else count = 0;
            if(count >= k) return false;
        }
        return true;
    }
}