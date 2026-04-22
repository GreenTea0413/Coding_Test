import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = "";
        while(n > 0){
            int rest = n % k;
            number = String.valueOf(rest) + number;
            n /= k;
        }
        
        String[] arr = number.split("0");
        
        for(String a : arr){
            if(a.equals("")) continue;
            
            Long num = Long.parseLong(a);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(Long n){
        if(n <= 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}