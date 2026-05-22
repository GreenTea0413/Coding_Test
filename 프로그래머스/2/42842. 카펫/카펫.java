class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int h = 1 ; h < total; h++){
            if(total % h == 0){
                int w = total / h;
                if(w >= h && (h - 2) * (w - 2) == yellow){
                    return new int[]{w,h};
                }
            }
        }
        return answer;
    }
}