class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 100000;
        
        // 이분탐색으로 하나씩 비교해보면서 left가 가장 큰 지점이 답
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(puzzle(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return answer;
    }
    
    public boolean puzzle(int[] diffs, int[] times, long limit, int level){
        int len = diffs.length;
        long time = times[0];
        // 처음엔 난이도가 무조건 1이라 풀기가능
        for(int i = 1; i < len; i++){
            if(diffs[i] > level){
                long diff = diffs[i] - level;
                time += (long)(times[i - 1] + times[i]) * diff + times[i];
            }
            else time += times[i];
            
            
            if(time > limit) return false;
        }
        
        return true;
    } 
}