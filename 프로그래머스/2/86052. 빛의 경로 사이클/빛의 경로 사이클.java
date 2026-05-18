import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        boolean[][][] visited = new boolean[rows][cols][4];
        
        // 0:상 1:하 2:좌 3:우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] turnL = {2, 3, 1, 0}; // 상→좌→하→우
        int[] turnR = {3, 2, 0, 1}; // 상→우→하→좌
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int d = 0; d < 4; d++){
                    if(visited[i][j][d]) continue;
                    
                    int x = i, y = j, dir = d;
                    int count = 0;
                    
                    while(!visited[x][y][dir]){
                        visited[x][y][dir] = true;
                        count++;
                        
                        // 현재 칸에서 방향 결정
                        char c = grid[x].charAt(y);
                        if(c == 'L') dir = turnL[dir];
                        else if(c == 'R') dir = turnR[dir];
                        
                        // 이동
                        x = (x + dx[dir] + rows) % rows;
                        y = (y + dy[dir] + cols) % cols;
                    }
                    
                    answer.add(count);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}