import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        // 이걸로 coruse 길이에 맞는 세트들만 만듬
        for(String ord : orders) {
            char[] o = ord.toCharArray();
            Arrays.sort(o);
            
            for(int c : course){
                dfs(o, 0, "", c);   
            }
        }
    
        // map에서 이제 value로 길이마다 가장 큰 값 찾기 course랑 같은 애들만 answer에 담기
        Map<Integer, Integer> max = new HashMap<>();
        
        // 이러면 이제 2개 이상 팔린 것 중에서 길이에 대해 최대값들을 넣음
        for(String key : map.keySet()){
            if(map.get(key) >= 2) {
                max.put(key.length(), Math.max(max.getOrDefault(key.length(), 0), map.get(key)));
            }
        }
        
        for(String key : map.keySet()){
            int len = key.length();
            int count = map.get(key);
            
            if(count >= 2 && max.get(len) == count) answer.add(key);
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    void dfs(char[] c, int start, String now, int depth){
        if(depth == 0) {
            map.put(now, map.getOrDefault(now, 0) + 1);
            return;
        }
        
        for(int i = start; i < c.length; i++) dfs(c, i + 1, now + c[i], depth - 1);
    }
}