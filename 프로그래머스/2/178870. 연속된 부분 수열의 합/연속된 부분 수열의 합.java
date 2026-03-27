import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        // index 값을 넣어야함
        int len = sequence.length;
        int[] answer = {0,len - 1};
        int sum = 0;
        int left = 0;
        int right = 0;
        
        // 길이 비교도 해야함
        while(right < len){
            sum += sequence[right];
            while(left < right && sum > k){
                sum -= sequence[left];
                left++;
            }
            if (sum == k) {
                if (answer[1] - answer[0] > right - left){
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            right++;
        }
        
        return answer;
    }
}