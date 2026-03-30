import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        int lenX = maps.length;
        int lenY = maps[0].length();
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[lenX][lenY];
        int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        
        for(int i = 0; i < lenX; i++){
            for(int j = 0; j < lenY; j++){
                if (maps[i].charAt(j) != 'X' && !v[i][j]){
                    q.offer(new int[]{i, j});
                    v[i][j] = true;
                    int sum = 0;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];
                        sum += maps[x].charAt(y) - '0';
                        
                        for(int k = 0; k < 4; k ++){
                            int nx = x + d[k][0];
                            int ny = y + d[k][1];
                            
                            if(0<= nx && nx< lenX && 0 <= ny && ny < lenY && !v[nx][ny] && maps[nx].charAt(ny) != 'X'){
                                v[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    answer.add(sum);
                }
            }
        }
        
        if (answer.size() == 0) return new int[]{-1};
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}