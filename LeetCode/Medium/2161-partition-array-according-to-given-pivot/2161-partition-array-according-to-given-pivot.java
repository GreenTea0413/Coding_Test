class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int idx = 0;
        int[] answer = new int[nums.length];

        for(int n : nums) if(n < pivot) answer[idx++] = n;
        for(int n : nums) if(n == pivot) answer[idx++] = n;
        for(int n : nums) if(n > pivot) answer[idx++] = n;

        return answer;
    }
}