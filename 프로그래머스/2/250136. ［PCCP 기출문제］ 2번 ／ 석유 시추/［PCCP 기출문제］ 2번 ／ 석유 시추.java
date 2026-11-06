import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int xLen = land.length;
        int yLen = land[0].length;
        int[][] arr = new int[xLen][yLen];
        int[] size = new int[xLen * yLen + 1];
        int[][] d = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        // 0 빈땅
        // 1 석유땅
        // 0 0 0 1 1 1 0 0
        // 0 0 0 0 1 1 0 0
        // ... 이렇게 가야하니까
        int id = 1;
        for(int i = 0; i < xLen; i++){
            Queue<int[]> q = new LinkedList<>();
            for(int j = 0; j < yLen; j++){
                // 이렇게 사이즈 land가 석유가 아닌곳 또는 이미 발견한 곳이면 넘기기
                if(land[i][j] == 0 || arr[i][j] != 0) continue; 
                
                // 그리고 이걸로 id arr에다가 매긴다음에 size에는 id가 총 size 몇인지 판단
                else if(land[i][j] == 1 && arr[i][j] == 0) {
                    arr[i][j] = id;
                    q.offer(new int[]{i, j});
                    int count = 1;
                    
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        
                        for(int k = 0; k < 4; k++){
                            int nx = now[0] + d[k][0];int ny = now[1] + d[k][1];
                            
                            if(nx < 0 || nx >= xLen || ny < 0 || ny >= yLen) continue;
                            if(arr[nx][ny] == 0 && land[nx][ny] == 1) {
                                arr[nx][ny] = id;
                                q.offer(new int[]{nx, ny});
                                count++;
                            }
                        }
                    }
                    size[id] = count;
                    id++;
                }
            }
        }
        
        // 이제 y좌표에 따라 한칸씩 내려가면서 해당 열에 id들을 모은 다음에
        // size에서 값 꺼내기
        for(int i = 0; i < yLen; i++){
            boolean[] v = new boolean[id + 1];
            
            for(int j = 0; j < xLen; j++) if(arr[j][i] != 0) v[arr[j][i]] = true;
            
            int total = 0;
            for(int k = 1; k < id + 1; k++) if(v[k]) total += size[k];
            
            answer = Math.max(total, answer);
        }
        return answer;
    }
}