import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        int[][] d = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) != 'X' && !v[i][j]){
                    int sum = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                    v[i][j] = true;
                    q.offer(new int[]{i, j});
                    
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        
                        for(int k = 0; k < 4; k++){
                            int nx = now[0] + d[k][0];
                            int ny = now[1] + d[k][1];
                            
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(maps[nx].charAt(ny) != 'X' && !v[nx][ny]) {
                                q.offer(new int[]{nx,ny});
                                v[nx][ny] = true;
                                sum += Integer.parseInt(String.valueOf(maps[nx].charAt(ny)));
                            }
                        }
                    }
                    
                    answer.add(sum);
                }
            }
        }
        
        if(answer.size() == 0) return new int[]{-1};
        
        answer.sort((a, b) -> a - b);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}