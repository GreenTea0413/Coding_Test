class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int range = w * 2 + 1;
        for(int s : stations){
            int left = s - w;
            
            if(start < left){
                answer += (left - start + range - 1) / range;
            }
            start = s + w + 1;
        }
        
        if(start <= n){
            answer += (n - start + range) / range;
        }
        return answer;
    }
}