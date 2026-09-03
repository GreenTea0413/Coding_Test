class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        int sum = 0;
        while(left <= right && right < sequence.length){
            sum += sequence[right];
            
            while(sum > k){
                sum -= sequence[left];
                left++;
            }

            if(sum == k){
                // 어차피 left를 밑에서 채우기 때문에 젤 작은 구간 찾기
                if(right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
                else if(right - left == answer[1] - answer[0]){
                    if(left < answer[0]){
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
            }
            right ++;
        }
        return answer;
    }
}