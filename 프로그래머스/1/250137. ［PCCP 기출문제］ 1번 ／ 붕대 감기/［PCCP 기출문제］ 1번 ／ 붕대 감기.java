class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int max = 0;
        for(int[] attack : attacks) max = Math.max(attack[0], max);
        
        int count = 0;
        int user = health;
        int idx = 0;
        for(int i = 1; i <= max; i++){
            if(idx < attacks.length && attacks[idx][0] == i){
                count = 0;
                user -= attacks[idx][1];
                idx++;
            }
            else{
                count++;
                user += bandage[1];
                
                if(bandage[0] == count){
                    user += bandage[2];
                    count = 0;
                }
            }
            
            if(user > health) user = health;
            if(user <= 0) return -1;
        }
        return user;
    }
}