class Solution {
    public int solution(int[] numbers, int target) {        
        return dfs(numbers, 0, target, 0);
    }
    
    public int dfs(int[] numbers, int count, int target, int cur){
        if(count == numbers.length){
            return (cur == target) ? 1 : 0;
        }
        
        int sum = 0;
        sum += dfs(numbers,count + 1, target, cur + numbers[count]);
        sum += dfs(numbers,count + 1, target, cur - numbers[count]);
        
        return sum;
    }
}