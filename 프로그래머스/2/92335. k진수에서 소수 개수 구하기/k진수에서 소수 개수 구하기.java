class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = "";
        while(n > 0){
            int rest = n % k;
            str = String.valueOf(rest) + str;
            n = n / k;
        }
        
        String[] arr = str.split("0");
        for(String s : arr) if(check(s)) answer++;
        
        return answer;
    }
    
    boolean check(String s){
        if(s.equals("")) return false;
        long num = Long.parseLong(s);
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}