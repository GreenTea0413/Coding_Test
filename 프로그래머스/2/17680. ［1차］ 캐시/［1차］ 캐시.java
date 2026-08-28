import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        q.offer(cities[0].toLowerCase());
        int answer = 5;
        int len = cities.length;
        
        if(cacheSize == 0) return len * 5;
        for(int i = 1; i < len; i++){
            String c = cities[i].toLowerCase();
            
            if(q.contains(c)) {
                answer++;
                q.remove(c);
                q.offer(c);
            }
            else{
                answer += 5;
                if(q.size() == cacheSize){
                    q.poll();
                }
                q.offer(c);
            }
        }
        
        
        return answer;
    }
}