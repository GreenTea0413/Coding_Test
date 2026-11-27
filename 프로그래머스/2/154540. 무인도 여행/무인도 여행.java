import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[][] d = {{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!v[i][j] && maps[i].charAt(j) != 'X'){
                    int sum = (int) maps[i].charAt(j) - '0';
                    q.offer(new int[]{i, j});
                    v[i][j] = true;
                    
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        
                        for(int k = 0; k < 4; k++){
                            int nx = now[0] + d[k][0]; int ny = now[1] + d[k][1];
                            
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            
                            if(!v[nx][ny] && maps[nx].charAt(ny) != 'X'){
                                q.offer(new int[]{nx,ny});
                                sum += (int) maps[nx].charAt(ny) - '0';
                                v[nx][ny] = true;
                            }
                        }
                    }
                    answer.add(sum);
                }
            }
        }
        Collections.sort(answer, (a, b) -> (a - b));
        return answer.size() > 0 ? answer.stream().mapToInt(i -> i).toArray() : new int[]{-1};
    }
}