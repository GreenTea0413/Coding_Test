class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // 범위를 구해서 이 범위 안에 기지국을 몇개 설치할지를 정해야함
        // 기지국 포함 좌우 w
        int range = w * 2 + 1;
        int start = 1;
        
        for(int station : stations){
            int left = station - w;
            
            // 기지국 left 기준으로 start보다 크다면 그 앞에는 기지국이 없다는 뜻
            if (start < left){
                int gap = left - start;
                answer += (gap + range - 1) / range;
            }
            
            start = station + w + 1;
        }
        
        if(start <= n){
            int gap = n - start + 1;
            answer += (gap + range - 1) / range;
        }
        
    
        return answer;
    }
}