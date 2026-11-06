class Solution {
    public int solution(int[] diffs, int[] times, long limit) {         
        long answer = Integer.MAX_VALUE;
        long left = 1;
        long right = limit;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            // 난이도가 0 ~ 30 중 4일때 당연히 다 풀겠지? 그러면 right를 줄여서 숙련도 낮추면서 계산
            // 근데 반대로 못맞추면 숙련도가 올라가도록 하기
            if(check(mid, diffs, times) <= limit){
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return (int) answer;
    }
    
    long check(long mid, int[] diffs, int[] times){
        long total = times[0];
        int prev = times[0];
        
        for(int i = 1; i < diffs.length; i++){
            long rest = diffs[i] - mid;
            
            if(rest <= 0) total += times[i];
            else total += rest * (prev + times[i]) + times[i];
            
            prev = times[i];
        }
        return total;
    }
}