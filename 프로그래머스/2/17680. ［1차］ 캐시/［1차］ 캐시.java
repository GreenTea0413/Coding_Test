import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 캐시 LRU 교체
        // queue의 크기가 cacheSize보다 작으면 그냥 확인
        // 이미 있다면 +1, 없으면 +5 후 queue에 넣기 
            // 하지만 cacheSize를 넘어가려고 하면 queue에서 가장 앞에꺼 빼고 넣기
        if (cacheSize == 0) {return cities.length * 5;}
        Queue<String> q = new LinkedList<>();
        for(String c : cities){
            String city = c.toUpperCase();
            
            if (q.contains(city)){
                answer += 1;
                q.remove(city);
                q.offer(city);
            }
            else{
                answer += 5;
                q.offer(city);
                if(q.size() > cacheSize){
                    q.poll();
                }
            }
        }       
        
        return answer;
    }
}