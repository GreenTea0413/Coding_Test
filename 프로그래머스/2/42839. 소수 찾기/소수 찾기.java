import java.util.*;

class Solution {
    Set<Integer> nSet = new HashSet<>();
    boolean[] v;
    public int solution(String numbers) {
        v = new boolean[numbers.length()];
        
        dfs("", numbers);
        
        int answer = 0;
        for(int num : nSet){
            if(isPrime(num)){
                answer ++;
            }
        }
        
        return answer;
    }
    
    public void dfs(String cur, String num){
        if(!cur.equals("")) nSet.add(Integer.parseInt(cur));
        
        for(int i = 0; i < num.length(); i++){
            if(!v[i]){
                v[i] = true;
                dfs(cur + num.charAt(i), num);
                v[i] = false;
            }
        }
    }
    
    
    public boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++)
        {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}