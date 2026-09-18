class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        mine(picks, minerals, 0, 0);
        
        return answer;
    }
    
    void mine(int[] picks, String[] minerals, int now, int total){
        if(picks[0] + picks[1] + picks[2] == 0 || now >= minerals.length){
            answer = Math.min(answer, total); 
            return;
        }
        // picks 처음부터 돌려서 minerals를 하나씩 캐면됨
        // minerals의 순서를 바꾸는건 아닌거 같
        // i 0번째 다이아, 1번째 철, 2번째     
        
        for(int i = 0; i < 3; i++){
            if(picks[i] != 0){
                int sum = 0;
                picks[i] --;
                int size = Math.min(now + 5, minerals.length);
                
                for(int j = now; j < size; j++){
                    // 다이아로 캘때
                    if(i == 0) sum++;
                    // 철로
                    else if(i == 1){
                        if(minerals[j].equals("diamond")) sum += 5;
                        else sum++;
                    }
                    //돌로
                    else{
                        if(minerals[j].equals("diamond")) sum += 25;
                        else if(minerals[j].equals("iron")) sum += 5;
                        else sum++;
                    }
                }
                
                mine(picks, minerals, size, total + sum);
                picks[i] ++;
            }
        }
    }
}