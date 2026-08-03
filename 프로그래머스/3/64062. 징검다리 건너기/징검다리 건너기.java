class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = Integer.MAX_VALUE;
        
        // 몇명이 뛰어갈 수 있을까
        // mid가 인원수라고 생각하고 못건너는 경우가 k 점프 이상이면 점점 줄여가야함
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(!check(mid, k, stones)){right = mid - 1; }
            else{left = mid + 1;}
        }
        
        return right;
    }
    
    boolean check(int mid, int k, int[] stones){
        int count = 0;
        for(int s : stones){
            if(s - mid < 0){
                count++;
                if(count >= k){
                    return false;
                }
            }
            else{count = 0;}
        }
        return true;
    }
}