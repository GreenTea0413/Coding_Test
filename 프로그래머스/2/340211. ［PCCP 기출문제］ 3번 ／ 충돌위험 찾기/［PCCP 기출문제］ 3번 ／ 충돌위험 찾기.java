import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        // 이동할 때는 next에서도 1만큼 감소하거나 증가한 좌표로만 이동가능 (r, c) -> (r + 1, c), (r - 1, c)
        // 늘 하던 상하좌우 이동 
        // r좌표가 변하는 이동을 먼저 함
        // 그렇게 이동하다가 만나는 횟수를 구해라
        // 전체 경로에 따라 지나가는 길들을 쭉 저장하기
        List<List<int[]>> paths = new ArrayList<>();
        int maxTime = 0;
        
        for(int[] route : routes){
            List<int[]> path = new ArrayList<>();
            int r = points[route[0] - 1][0];
            int c = points[route[0] - 1][1];
            
            path.add(new int[]{r, c});
            
            for (int k = 1; k < route.length; k++) {
                int tr = points[route[k] - 1][0];
                int tc = points[route[k] - 1][1];

                while (r != tr) {                        
                    r += (tr > r) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
                while (c != tc) {                         
                    c += (tc > c) ? 1 : -1;
                    path.add(new int[]{r, c});
                }
            }
            paths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }
        
        int answer = 0;
        for (int t = 0; t < maxTime; t++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (List<int[]> path : paths) {
                if (t >= path.size()) continue;         
                int[] p = path.get(t);
                int key = p[0] * 101 + p[1];
                map.put(key, map.getOrDefault(key, 0) + 1);
                if (map.get(key) == 2) answer++;                  
            }
        }
        
        return answer;
    }
}