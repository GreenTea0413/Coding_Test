class Solution {
    public int solution(int[] numbers, int target) { 
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int cur, int depth){
        if(depth == numbers.length){
            if(cur == target) return 1;
            else return 0;
        }
        
        return dfs(numbers, target, cur + numbers[depth], depth + 1) + dfs(numbers, target, cur - numbers[depth], depth + 1);
    }
}