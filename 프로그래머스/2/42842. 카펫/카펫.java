class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int h = 1; h < sum; h++){
            if(sum % h == 0){
                int s = sum / h;
                if(s < h) continue;
                if((s - 2) * (h - 2) == yellow){
                    answer[0] = s; answer[1] = h;
                }
            }
        }
        return answer;
    }
}