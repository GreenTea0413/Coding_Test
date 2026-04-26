import java.util.*;
class Solution {
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        
        char[][] maps = new char[n + 2][m + 2];
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                maps[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        // char는 비어있으면 \0과 비교하면 된다
        // \0이 중간에 들어갈 수 도 있으니 주변에 reachable 도달가능 한지를 비교
        int answer = n * m;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        for(String re : requests){
            // 치울 목록 배열
            List<int[]> list = new ArrayList<>();
            
            // 이걸로 도달 할 수 있는지 확인
            boolean[][] reachable = new boolean[n + 2][m + 2];
            Queue<int[]> q = new LinkedList<>();
            
            q.offer(new int[]{0, 0});
            reachable[0][0] = true;
            
            while(!q.isEmpty()){
                int[] now = q.poll();
                for(int i =0; i < 4; i++){
                    int nx = now[0] + dx[i];    
                    int ny = now[1] + dy[i];
                    
                    if(nx < 0 || nx >= n + 2 || ny < 0 || ny >= m + 2) continue;
                    if(maps[nx][ny] == '\0' && !reachable[nx][ny]){
                        reachable[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            
            
            if(re.length() == 1){
                for(int i = 1; i < n + 1; i++){
                    for(int j = 1; j < m + 1; j++){
                        if(maps[i][j] == re.charAt(0)){
                            if(reachable[i][j-1] || reachable[i][j+1] ||
                               reachable[i-1][j] || reachable[i+1][j]){
                                list.add(new int[]{i, j});
                            }
                        }
                    }
                }
                
                for(int[] xy : list){
                    maps[xy[0]][xy[1]] = '\0';
                    answer--;
                }
            }
            // 2글자면 그냥 다 치워버리면 됨
            else{
                for(int i = 1; i < n + 1; i++){
                    for(int j = 1; j < m + 1; j++){
                        if(maps[i][j] == re.charAt(0)){
                            maps[i][j] = '\0';
                            answer--;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}