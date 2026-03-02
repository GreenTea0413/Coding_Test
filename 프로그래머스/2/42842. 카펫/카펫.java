class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sq = brown + yellow;
        // 너비를 딱 나누는 가로 s
        // 가로 s * 높이 h 
        for(int s = 1; s < sq; s++){
            if(sq % s == 0){
                int h = sq / s;
                if(s >= h && (s-2) * (h-2) == yellow){
                    answer = new int[]{s, h};
                }
            }
        }
        
        
        return answer;
    }
}