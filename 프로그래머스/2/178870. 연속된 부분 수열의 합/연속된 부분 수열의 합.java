class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int len = sequence.length;
        int size = len + 1;
        int sum = 0;
        
        while(right < len){    
            sum += sequence[right];
            if (sum > k){
                while(sum > k && left <= right){
                    sum -= sequence[left];
                    left++;
                }
            }
            if (sum == k) {
                int s = right - left + 1;
                if(size > s) {
                    size = s;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            right++;
        }
        return answer;
    }
}