class Solution {
    public int[] solution(int n, long left, long right) {
        long gap = right - left;
        int[] answer = new int[(int) gap + 1];
        
        // 0,0 - 0 / 0, 1 - 1 / 0, 2 - 2 / 1, 0 - 3 / 1, 1 - 4 / 1, 2 - 5 /
        for(int i = 0; i < gap + 1; i ++){
            long idx = left + i;
            
            long row = idx / n;
            long col = idx % n;
            
            answer[i] = (int) (Math.max(row, col)) + 1;
        }
        
        return answer;
    }
}