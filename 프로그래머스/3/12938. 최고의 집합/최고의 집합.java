class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        
        int div = s / n;
        int rest = s % n;
        
        for(int i = 0; i < n; i++){
            answer[i] = div;
        }
        
        for(int i = n - 1; i >= n - rest; i--){
            answer[i] += 1;
        }
        return answer;
    }
}