class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int depth, int total){
        if(numbers.length == depth){
            if(total == target) return 1;
            else return 0;
        }
        
        return dfs(numbers, target, depth + 1, total + numbers[depth]) + dfs(numbers, target, depth + 1, total - numbers[depth]);
        
        
    }
}