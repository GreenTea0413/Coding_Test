import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        boolean[] v = new boolean[len];
        
        permute("",v,numbers);
        
        for(int num : set){
            if (prime(num)){
                answer++;
            }
        }
        return answer;
    }
    
    public void permute(String current, boolean[] visited, String numbers){
        if (!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                permute(current + numbers.charAt(i), visited, numbers);
                
                visited[i] = false;
            }
        }
    }
    
    public boolean prime(int number){
        if (number < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }
        return true;
    }
}