class Solution {
    public int solution(int n, int[] cores) {
        // 작업 갯수가 코어보다 적으면 바로 끝내기
        int len = cores.length;
        if (len >= n) return n;
        
        long lo = 1;
        long hi = (long)n * 10000L;
        
        while(lo < hi){
            long mid = (lo + hi) / 2;
            
            if(total(mid, cores) >= n){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        
        // 결국 최소로 끝나는 시간 lo 거기서 - 1한 다음에 그전에 몇개가 끝나는지 확인
        long finishTime = lo;
        long doneBefore = total(finishTime - 1, cores);
        long remain = n - doneBefore;
        
        for(int i = 0; i < len; i++){
            if (finishTime % cores[i] == 0) {
                remain--;
                if (remain == 0) {
                    return i + 1;
                }
            }
        }
        
        return -1;
    }
    
    public long total(long t, int[] cores){
        long sum = cores.length;
        for(int c : cores){
            sum += t / c;
        }
        return sum;
    }
}