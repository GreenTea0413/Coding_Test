class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int count, int index){
        if (index == numbers.length){
            if (target == count){
                return 1;
            }
            else return 0;
        }
        
        return dfs(numbers, target, count - numbers[index], index + 1) + dfs(numbers, target, count + numbers[index], index + 1);
    }
}