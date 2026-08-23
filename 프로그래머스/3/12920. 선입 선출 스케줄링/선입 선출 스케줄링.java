class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        // 이분탐색으로 풀기
        int len = cores.length;
        int left = 0;
        int right = 10000 * n;
        int time = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            int count = len;
            for(int c : cores) {
                count += mid / c;
            }
            
            if(count < n) left = mid + 1;
            else {
                right = mid - 1;
                time = mid;
            }
        }
        
        int rest = len;
        for(int c : cores) {
            rest +=  (time - 1) / c;
        }
        rest = n - rest;
        
        for(int i = 0; i < len; i++){
            if(time % cores[i] == 0){
                rest --;
                if(rest == 0) return i + 1;
            }
        }
        
        return answer;
    }
}