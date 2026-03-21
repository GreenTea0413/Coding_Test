class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left) + 1;
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++){
            long index = left + i;
            
            int col = (int) (index / n);
            int row = (int) (index % n);
            
            answer[i] = Math.max(col, row) + 1;
        }
        return answer;
    }
}