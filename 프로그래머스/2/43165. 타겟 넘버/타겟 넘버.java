class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int depth, int num){
        if(depth == numbers.length) {
            if (num == target) return 1;
            else return 0;
        }
        
        return dfs(numbers, target, depth + 1, num + numbers[depth]) + dfs(numbers, target, depth + 1, num - numbers[depth]);
    }
}