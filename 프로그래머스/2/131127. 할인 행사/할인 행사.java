class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < discount.length - 9; i++){
            int[] copy = number.clone();
            for(int j = i; j < i + 10; j++){
                for(int l = 0; l < want.length; l++){
                    if(want[l].equals(discount[j])) copy[l] -= 1;
                }
                
                boolean check = true;
                for(int k = 0; k < copy.length; k++){
                    if (copy[k] < 0) {check = false; break;}
                    if (copy[k] > 0) {check = false; break;}
                }
                
                if(check) answer++;
            }
        }
        return answer;
    }
}