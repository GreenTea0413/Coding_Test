class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage가 t, x, y인거네
        // y는 0 ~ t초 쭈욱하다가 t까지 성공하면 추가로 해주는거임
        int last = attacks[attacks.length - 1][0];
        int temp = health;
        int count = 0;
        int idx = 0;
        
        for(int i = 1; i <= last; i++){
            if(attacks[idx][0] == i) {
                temp -= attacks[idx][1];
                count = 0;
                idx++;
            }
            else if(temp < health) {
                count++;
                temp += bandage[1];
                
                if(count == bandage[0]) {
                    count = 0;
                    temp += bandage[2];
                }
            }
            if(temp > health) temp = health;
            if(temp <= 0) return -1;
        }
        
        
        
        return temp;
    }
}