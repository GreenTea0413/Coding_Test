class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }
    
    int dfs(int[] numbers, int idx, int target, int cur){
        if(numbers.length == idx){
            return (cur == target) ?  1 : 0;
        }
        
        int sum =0;
        sum += dfs(numbers, idx+1, target, cur + numbers[idx]);
        sum += dfs(numbers, idx+1, target, cur - numbers[idx]);
        
        return sum;
    }
}