import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int iLen = info.length;
        int qLen = query.length;
        
        for(String s : info){
            String[] arr = s.split(" ");
            dfs("", 0, arr);
        }
        
        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }
        
        
        int[] answer = new int[qLen];
        
        for(int i = 0; i < qLen; i++){
            String[] q = query[i].replace(" and ", " ").split(" ");
            
            int score = Integer.parseInt(q[4]);
            String key = q[0] + " " + q[1] + " " + q[2] + " " + q[3];
            
            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }
            List<Integer> list = map.get(key);
            answer[i] = binarySearch(list, score);
        }

        return answer;
    }
    
    public void dfs(String cur, int depth, String[] arr){
        if(depth == 4){
            map.computeIfAbsent(cur.trim(), k -> new ArrayList<>()).add(Integer.parseInt(arr[4]));
            return;
        }
        
        dfs(cur + "- ", depth + 1, arr);
        dfs(cur + arr[depth] + " ", depth + 1, arr);
    }
    
    public int binarySearch(List<Integer> list, int score){
        int left = 0, right = list.size();
        
        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid) < score) left = mid + 1;
            else right = mid;
        }
        
        return list.size() - left;
    }
}