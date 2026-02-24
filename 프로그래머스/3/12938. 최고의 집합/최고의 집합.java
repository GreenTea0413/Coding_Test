class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        
        int num = s / n;
        int remain = s % n;
        for (int i = 0; i < n; i++){
            answer[i] = num;
        }
        
        for (int i = n - 1; i >= n - remain; i--){
            answer[i] += 1;
        }
        return answer;
    }
}