import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        boolean[] v= new boolean[len];
        permutate(numbers, v, "");
        
        for(int n : set){
            if(isPrime(n)) answer++;
        }
        return answer;
    }
    
    public void permutate(String numbers, boolean[] v, String now){
        if(!now.equals("")) {
            set.add(Integer.parseInt(now));
        }
        
        for(int i = 0 ; i < numbers.length(); i++){
            if(!v[i]){
                v[i] = true;
                permutate(numbers, v, now + numbers.charAt(i));
                v[i] = false;
            }
        }
    }
    public boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}