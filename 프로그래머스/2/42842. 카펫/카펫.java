class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 1; i < sum; i++){
            if(sum % i == 0){
                int s = sum / i;
                if(s >= i){
                    if((s - 2) * (i - 2) == yellow) return new int[]{s, i};
                }
            }
        }
        return answer;
    }
}