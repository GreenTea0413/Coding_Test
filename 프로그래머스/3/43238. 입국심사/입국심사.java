class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = 0;
        for(int t : times){max = Math.max(t, max);}
        
        long right = n * max;
        if(n == 1) return right;
        
        // 이런문제는 이분탐색으로 풀어야함
        long left = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            long rest = 0;
            for(int t : times){
                rest += mid / t;
            }
            // 처음에 mid가 30, 7과 10으로 나누면 3 + 3 6이 나옴
            // 하지만 이것보다 더 줄일 수 있으니까
            if(rest >= n){right = mid - 1;}
            else{left = mid + 1; answer = mid + 1;}
        }
        return answer;
    }
}