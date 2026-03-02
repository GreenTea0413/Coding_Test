import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] v = new boolean[numbers.length()];
        permutation(numbers, v, "");
        
        for(int num : set){
            if (isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    
    public void permutation(String numbers, boolean[] v, String cur){
        if(!cur.equals("")){
            set.add(Integer.parseInt(cur));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!v[i]){
                v[i] = true;
                permutation(numbers, v, cur + numbers.charAt(i));
                v[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num){
        if (num < 2){ return false; }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}