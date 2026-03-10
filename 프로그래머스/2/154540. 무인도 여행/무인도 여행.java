import java.util.*;

class Solution {
    int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int x_len;
    int y_len;
    public int[] solution(String[] maps) {
        ArrayList<Integer> island = new ArrayList<>();
        x_len = maps.length;
        y_len = maps[0].length();
        
        int[][] arr = new int[x_len][y_len];
        boolean[][] v = new boolean[x_len][y_len];
        
        // map 만들기
        int i = 0;
        for(String s : maps){
            for(int j = 0; j < y_len; j++){
                char temp = s.charAt(j);
                arr[i][j] = (temp == 'X') ? -1 : temp - '0';
            }
            i++;
        }
                
        // X가 아니고 방문안했다면?
        for(int k = 0; k < x_len; k++){
            for(int l = 0; l < y_len; l++){
                if(!v[k][l] && arr[k][l] != -1){
                    island.add(bfs(arr, k, l, v));
                }
            }
        }
        
        
        if (island.size() == 0 ) return new int[]{-1};
        
        int[] answer = island.stream().mapToInt(n -> n).toArray();
        Arrays.sort(answer);
        return answer;
    }
    
    public int bfs(int[][] arr, int x, int y, boolean[][] v){
        int food = 0;
        v[x][y] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            food += arr[cx][cy];
            
            for(int i =0; i < 4; i++){
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];
                
                if(0 <= nx && nx < x_len && 0 <= ny && ny < y_len && !v[nx][ny] && arr[nx][ny] != -1){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return food;   
    }
}