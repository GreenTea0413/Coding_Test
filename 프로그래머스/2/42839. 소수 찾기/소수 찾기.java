import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        boolean[] v = new boolean[len];
        permutation("", v, numbers);
        
        for (int num : set){
            if(prime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void permutation(String current, boolean[] visited, String numbers){
        if (!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        int len = numbers.length();
        for(int i = 0; i < len; i ++){
            if (!visited[i]){
                visited[i] = true;
                permutation(current + numbers.charAt(i), visited, numbers);
                visited[i] = false;
            }
        }
    }
    
    public boolean prime(int num){
        if (num < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}