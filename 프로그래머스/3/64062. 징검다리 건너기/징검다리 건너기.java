class Solution {
    public int solution(int[] stones, int k) {
        // 무조건 돌 1이상이면 밟고 지나가야함
        // 만약에 0이면 그 다음에 k 까지 뛰어갈 수 있음
        // 그러면 최대 인원수에서 이분탐색으로 돌을 몇명 건널 수 있는지 확인하기
        
        int left = 1;
        int right = 200000000;
        
        while(left <= right){
            int mid = (left + right ) / 2;
            
            if(check(stones, mid, k)){left = mid + 1;}
            else{right = mid - 1;}
        }
        return right;
    }
    
    public boolean check(int[] stones, int mid, int k){
        int count = 0;
        // 이제 돌 하나씩 밟으면서 s - mid를 했을 때 0보다 크면 그냥 지나가면 됨
        // 만약에 s - mid가 0보다 작으면 count를 세서 이게 k보다 크면 0 0 0 0 이렇게 되어있는거니까 실패
        for(int s : stones){
            if(s - mid < 0) count++;
            else {count = 0;}
            if(count >= k) return false;
        }
        
        return true;
    }
}