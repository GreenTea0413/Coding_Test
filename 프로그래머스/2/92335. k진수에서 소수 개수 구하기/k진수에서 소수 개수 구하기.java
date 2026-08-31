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
        for(String a : arr){
            if(!a.equals("") && check(Long.parseLong(a))) answer++;
        }
        return answer;
    }
    
    boolean check(Long n){
        if(n < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}