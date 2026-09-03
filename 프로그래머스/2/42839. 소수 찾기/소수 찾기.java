import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        int len = arr.length;
        int answer = 0;
        
        // 1 7
        dfs(arr, "", new boolean[len]);
        
        for(int s : set){
            if(check(s)) answer++;
        }
        return answer;
    }
    
    void dfs(String[] arr, String now, boolean[] v){
        if(!now.equals("")) set.add(Integer.parseInt(now.toString()));
        
        for(int i = 0; i < arr.length; i++){
            if(!v[i]){
                v[i] = true;
                now += arr[i];
                
                dfs(arr, now, v);
                
                v[i] = false;
                now = now.substring(0, now.length() - 1);
            }
        }
    }
    
    boolean check(int n){
        if(n < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}