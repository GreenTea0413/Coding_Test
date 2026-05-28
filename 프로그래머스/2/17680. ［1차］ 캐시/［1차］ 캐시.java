import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {return cities.length * 5;}
        
        Queue<String> q = new LinkedList<>();
        
        for(String city : cities){
            String temp = city.toLowerCase();
            
            
            // q안에 도시가 있다면?
            if(q.contains(temp)){
                answer+=1;
                q.remove(temp);
                q.offer(temp);
            }
            else{
                answer += 5;
                q.offer(temp);
                if(q.size() > cacheSize){
                    q.poll();
                }
            }
        }
        
        
        return answer;
    }
}