class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = "";
        
        while(n > 0){
            int rest = n % k;
            num = String.valueOf(rest) + num;
            n = n / k;
        }
        
        String[] arr = num.split("0");
        for(String a : arr){
            if(a.equals("")) continue;
            
            Long temp = Long.parseLong(a);
            if(check(temp)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(Long num){
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}