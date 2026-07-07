class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // stations을 기준으로 1부터 시작했을 때 그 갭 차이 만큼 들어갈 수 있는지 확인
        // 4 -> 3, 5 1부터 시작하면 gap == 2 1개만 들어가면 됨
        // 11 -> 10, 12여서 아까 구헌거 idx == 6으로 시작해서 10 - 6 4칸인데 w 생각하면 2개 가능
        // 여기서 1개를 그냥 1칸말고 w * 2 + 1을 범위로 지정
        // 범위보다 -1 한거 만큼 더해주고 범위 만큼 나누면 +1한 것 보다 더 정교하게 구간 나누기 가능
        int idx = 1;
        int range = w * 2 + 1;
        for(int s : stations){
            int start = s - w;
            int end = s + w;
            
            int gap = start - idx;
            int count = (gap + range - 1) / range;
            
            answer += count;
            idx = end + 1;
        }
        
        if(idx <= n){
            int gap = n - idx;
            int count = (gap + range) / range;
            answer += count;
        }

        return answer;
    }
}