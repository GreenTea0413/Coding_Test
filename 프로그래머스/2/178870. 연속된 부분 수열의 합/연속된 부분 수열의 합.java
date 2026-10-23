class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        
        int[] answer = new int[2];
        int len = sequence.length;
        
        int sum = 0;
        while(right < sequence.length){
            sum += sequence[right];
    
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            if(sum == k){
                if(right - left < len){
                    len = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            
            right++;
        }
        
        return answer;
    }
}