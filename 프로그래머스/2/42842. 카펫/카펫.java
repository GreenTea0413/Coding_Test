class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int h = 1; h <= sum; h++){
            int w = 0;
            if(sum % h == 0){
                // 1 12, 2 6, 3 4
                // s가 가로
                w = sum / h;
                if(w >= h && (w - 2) * (h - 2) == yellow) return new int[]{w, h};
                
            }
        }
        return answer;
    }
}