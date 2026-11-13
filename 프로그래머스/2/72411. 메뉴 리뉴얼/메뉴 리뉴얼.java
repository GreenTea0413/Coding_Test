import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        // dfs 백트래킹으로 싹다 모아놓기
        // course길이 만큼으로해서 o에서 뽑아낼 수 있는거 다 뽑아내고 map에서 2이상인 것들 꺼내서 배치하기!
        for(String o : orders){
            char[] c = o.toCharArray();
            Arrays.sort(c);
            for(int l : course){
                dfs(c, l, "", 0);
            }
        }
    
        Map<Integer, Integer> maxMap = new HashMap<>();
        for(int c : course){
            int max = 2;
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(c == entry.getKey().length()) max = Math.max(max, entry.getValue());
            }
            maxMap.put(c, max);
        }
        
        for(Map.Entry<Integer, Integer> m : maxMap.entrySet()){
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(m.getKey() == entry.getKey().length() && m.getValue() == entry.getValue()){
                    answer.add(entry.getKey());
                } 
            }
        }
        
        answer.sort((a, b) -> a.compareTo(b));
        return answer.toArray(new String[0]);
    }
    
    void dfs(char[] order, int len, String now, int start){
        if(now.length() == len){
            map.put(now, map.getOrDefault(now, 0) + 1);
            return;
        }
        
        for(int i = start; i < order.length; i++){
            dfs(order, len, now + order[i], i + 1);
        }
    }
}