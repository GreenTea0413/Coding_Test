class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = sequence.length;
        
        int left = 0;
        int right = 0;
        int total = len;
        int sum = 0;
        // index를 내보내는 작업
        while(right < len){
            sum += sequence[right];
            
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                int now = right - left;
                if(total > now){
                    total = now;
                    answer[0] = left; answer[1] = right;
                }
            }
            right++;
        }
        
        return answer;
    }
}