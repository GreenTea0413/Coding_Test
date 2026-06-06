import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int len = numbers.length();
        char[] c = numbers.toCharArray();
        
        permute(c, new boolean[len], "");
        
        int answer = 0;
        for(int n : set){
            if(isPrime(n)) answer++;
        }
        return answer;
    }
    
    void permute(char[] c, boolean[] v, String now){
        if(!now.equals("")) set.add(Integer.parseInt(now));
        
        for(int i = 0; i < c.length; i++){
            if(!v[i]){
                v[i] = true;
                permute(c, v, now + String.valueOf(c[i]));
                v[i] = false;                
            }
        }
    }
    
    boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}