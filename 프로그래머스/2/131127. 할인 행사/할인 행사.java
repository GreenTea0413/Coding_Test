class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = discount.length;
        
        for(int i = 0 ; i < len - 9; i++){
            int[] copy = number.clone();
            //10일 연속으로 가야하니까 이렇게 끊고
            for(int j = i; j < i + 10; j++){
                for(int k = 0; k < want.length; k++){
                    if(discount[j].equals(want[k])){
                        copy[k] -= 1;
                    }
                }
            }
            
            boolean check = true;
            
            for(int j = 0; j < copy.length; j++){
                if(copy[j] > 0){check = false; break;}
                if(copy[j] < 0){check = false; break;}
            }
            
            if(check) answer++;
        }
        
        return answer;
    }
}