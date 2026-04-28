import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        // points는 거점
        // routes는 [4,2]면 idx point 3번째에서 1번째로 가야함
        
        // 그러면 각 routes에 대하여 경로를 다 기억해서 비교?
        // 가로 먼저 움직이고 세로 움직여야함
        List<List<int[]>> allPaths = new ArrayList<>();
        
        for(int[] route : routes){
            // [2,2]에서 시작
            int[] start = points[route[0] - 1];
            int r = start[0];
            int c = start[1];
            
            List<int[]> path = new ArrayList<>();
            path.add(new int[]{r, c});
            
            // route = [2,3,4,5]
            // 4번 반복해야하니까 route길이
            // target은 i에 대해서 다음 목적지 points
            for(int i = 1; i < route.length; i++){
                int[] target = points[route[i] - 1];
                
                // 위아래 먼저 움직이기 r부터 움직이라고 했음
                while(r != target[0]){
                    r += (target[0] > r) ? 1 : -1; 
                    path.add(new int[]{r, c});
                }
                
                while(c != target[1]){
                    c += (target[1] > c) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
            }
            // 그러면 이제 모든 경로를 기록함
            allPaths.add(path);
        }
        
        int maxTime = 0;
        for (List<int[]> path : allPaths) {
            maxTime = Math.max(maxTime, path.size());
        }
        
        for(int t = 0; t < maxTime; t++){
            Map<String, Integer> map = new HashMap<>();
            
            for(List<int[]> path : allPaths){
                if(t < path.size()){
                    int x = path.get(t)[0];
                    int y = path.get(t)[1];
                    
                    String temp = String.valueOf(x) + "," + String.valueOf(y);
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
            }
            for(int count : map.values()){
                if(count >= 2) answer++;
            }
        }
        return answer;
    }
}