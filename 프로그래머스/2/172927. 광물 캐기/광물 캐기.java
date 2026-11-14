class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        mine(picks, minerals, 0, 0);
        return answer;
    }
    
    void mine(int[] picks, String[] minerals, int start, int total){
        if(picks[0] + picks[1] + picks[2] == 0 || minerals.length == start){
            answer = Math.min(answer, total);
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(picks[i] != 0){
                picks[i]--;
                
                int min = Math.min(start + 5, minerals.length);
                int sum = 0;
                for(int j = start; j < min; j++){
                    if(i == 0) sum++;
                    else if(i == 1) {
                        if(minerals[j].equals("diamond")) sum += 5;
                        else sum ++;
                    }
                    else{
                        if(minerals[j].equals("diamond")) sum += 25;
                        else if(minerals[j].equals("iron")) sum += 5;
                        else sum++;
                    }
                }
                mine(picks, minerals, min, total + sum);
                
                picks[i] ++;
            }
        }
    }
    
}