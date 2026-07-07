class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        // 곱이 최대로 되기 위해서는 여기서 s / n 만큼 하고 거기서 부족한 만큼 더해주면 끝?
        int mid = s / n;
        int total = mid * n;
        int gap = s - total;
        for(int i = 0; i < n; i++){
            answer[i] = mid;
        }
        
        if(gap > 0){
            int last = n - 1;
            for(int i = 0; i < gap; i++){
                answer[last] += 1;
                last--;
            }
        }
        return answer;
    }
}