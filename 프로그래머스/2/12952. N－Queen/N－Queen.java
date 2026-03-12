class Solution {
    int answer = 0;
    int[] col;
    public int solution(int n) {
        col = new int[n];
        dfs(n, 0);
        return answer;
    }
    
    public void dfs(int n, int row){
        if(n == row){
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            col[row] = i;
            if(isPossible(row)){
                dfs(n, row + 1);
            }
        }
    }
    
    public boolean isPossible(int row){
        for(int i =0; i < row; i++){
            if (col[i] == col[row]) return false;
            if (Math.abs(col[i] - col[row]) == Math.abs(i - row)) return false;
        }
        
        return true;
    }
}