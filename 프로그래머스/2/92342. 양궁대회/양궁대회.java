class Solution {
    int[] apeach;
    int[] lion = new int[11];
    int[] answer = {-1};
    int max = 0;
    
    public int[] solution(int n, int[] info) {
        // 앞에서부터 1칸씩 비교하기, 화살 갯수
        this.apeach = info;
        dfs(0, n);
        
        return answer;
    }
    
    // 차피 깊이가 10이라서 끝까지 내려가도 충분히 할만함
    void dfs(int idx, int arrow){
        // 깊이 10되면 이제 비교하기
        if(idx == 10){
            lion[idx] = arrow;
            compare();
            
            lion[idx] = 0;
            return;
        }
        
        
        if(apeach[idx] < arrow){
            lion[idx] = apeach[idx] + 1;
            dfs(idx + 1, arrow - lion[idx]);
            lion[idx] = 0;
        }
        
        dfs(idx + 1, arrow); // 이건 화살안쓰고 그냥 넘어가기
    }
    
    void compare(){
        int a = 0; int l = 0;
        for(int i = 0; i < 11; i++){
            if(apeach[i] == 0 && lion[i] == 0) continue;
            if(apeach[i] >= lion[i]) a += (10 - i);
            else l += (10 - i);
        }
        
        int diff = l - a;
        if(diff <= 0) return;
        
        // l이 더 크고 맥스보다 더 크면
        if(diff > max){
            max = diff;
            answer = lion.clone();
        }
        else if(diff == max){
            for(int i = 10; i >= 0; i --){
                if(answer[i] != lion[i]){
                    if(answer[i] < lion[i]) answer = lion.clone();
                    break;
                }
            }
        }
    }
}