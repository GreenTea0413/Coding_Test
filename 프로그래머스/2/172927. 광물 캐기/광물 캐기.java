class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        // 시작점, 합
        mine(picks, minerals, 0, 0);
        return answer;
    }
    
    void mine(int[] picks, String[] minerals, int start, int total){
        if((picks[0] + picks[1] + picks[2] == 0) || start >= minerals.length){
            answer = Math.min(total, answer); return;
        }
        
        // 곡괭이 3 종류 중에서 1개씩 백트래킹
        for(int i = 0; i < 3; i++){
            if(picks[i] != 0){
                picks[i]--;
                
                // 곡괭이 하나당 무조건 5개 이상 캐야함
                // 근데 mineral이 마지막에 5개가 안될 수도 있으니
                int end = Math.min(start + 5, minerals.length);
                int sum = 0;
                for(int j = start; j < end; j++){
                    if(i == 0) sum ++;
                    else if(i == 1){
                        if(minerals[j].equals("diamond")) sum += 5;
                        else sum ++;
                    }
                    else {
                        if(minerals[j].equals("diamond")) sum += 25;
                        else if(minerals[j].equals("iron")) sum += 5;
                        else sum ++;
                    }
                }
                mine(picks, minerals, end, total + sum);
                picks[i]++;
            }
        }
    }
}