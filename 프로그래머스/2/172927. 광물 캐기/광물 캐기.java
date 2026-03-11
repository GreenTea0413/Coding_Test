class Solution {
    int answer = 1250;
    public int solution(int[] picks, String[] minerals) {
        mine(picks, minerals, 0, 0);
        return answer;
    }
    
    // 곡괭이로 땅파기
    // 현재 곡괭이 값에 따른 minerals * 피로도 해서 다음으로 넘기기
    
    public void mine(int[] picks, String[] minerals, int total, int now){
        if (picks[0] + picks[1] + picks[2] == 0 || now >= minerals.length){
            answer = Math.min(total, answer);
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(picks[i] != 0){
                picks[i]--;
                int cost = 0;
                int size = Math.min(now + 5, minerals.length);
                
                for(int j = now; j < size; j++){
                    // 곡괭이
                    if (i == 0) {
                        cost += 1;
                    }
                    else if(i == 1){
                        // 광물
                        if (minerals[j].equals("diamond")) cost += 5;
                        else cost += 1;
                    }
                    else{
                        if (minerals[j].equals("diamond")) cost += 25;
                        else if (minerals[j].equals("iron")) cost += 5;
                        else cost += 1;
                    }
                }
                
                mine(picks, minerals, total+ cost, now + 5);
                picks[i]++;
            }
        }
    }
}