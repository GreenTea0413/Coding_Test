import java.util.*;
class Solution {
    Set<Integer> nSet = new HashSet<>();
    boolean[] v;
    public int solution(String numbers) {
        v = new boolean[numbers.length()];
        dfs("", numbers);
        
        int answer = 0;
        for(int num : nSet){
            if(isPrime(num))
                answer ++;
        }
        return answer;
    }
    
    public void dfs(String cur, String numbers){
        if(!cur.equals("")) nSet.add(Integer.parseInt(cur));
        
        for(int i = 0; i < numbers.length(); i++){
            if(!v[i]){
                v[i] = true;
                dfs(cur + numbers.charAt(i), numbers);
                v[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n < 2) return false;
        
        for(int i = 2; i <=Math.sqrt(n); i++)
        {
            if(n % i == 0)  return false;
        }
        return true;
     }
}