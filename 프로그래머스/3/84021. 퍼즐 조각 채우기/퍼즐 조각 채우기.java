import java.util.*;

class Solution {
    int[][] d = {{0,1}, {0,-1},{1,0},{-1,0}};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = table.length;
        int m = table[0].length;
        
        List<List<int[]>> gameBlock = new ArrayList<>();
        List<List<int[]>> tableBlock = new ArrayList<>();
        
        boolean[][] gameV = new boolean[n][m];
        boolean[][] tableV = new boolean[n][m];
        
        // 비어있는 곳 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!gameV[i][j] && game_board[i][j] == 0){
                    gameBlock.add(dfs(gameV, game_board, i, j, 0));
                }
            }
        }
        
        // 블럭 찾기 이걸로 이제 좌표들 다 찾아서 넣는거임
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!tableV[i][j] && table[i][j] == 1){
                    tableBlock.add(dfs(tableV, table, i, j, 1));
                }
            }
        }
        
        
        // 이제 각각 빈칸이랑 블럭들 다 모았으면 맞춰봐야함
        boolean[] v = new boolean[tableBlock.size()];
        
        for(List<int[]> game : gameBlock){
            // 위치 최소로 맞춰서 2, 3 -> 0,1로 표준화
            List<int[]> blank = normalizer(game);
            
            // 이제 블록 하나씩 꺼내서 해봐야함
            for(int i = 0; i < tableBlock.size(); i++){
                // 이미 사용한 블럭은 x
                if(v[i]) continue;
                
                // 블록 또한 표준화 시키기 그리고 회전 시켜서 4번 해봐야함
                List<int[]> block = tableBlock.get(i);
                boolean matched = false;
                
                for(int j = 0; j < 4; j++){
                    // 돌린 다음에 각 블럭들 끼리 맞는지 확인
                    List<int[]> normBlock = normalizer(block); 
                    if(match(blank, normBlock)){
                        v[i] = true; 
                        answer += block.size();
                        matched = true;
                        break;
                    }
                    block = rotate(block);
                }
                if(matched) break;
            }
            
        }
        
        return answer;
    }
    
    public List<int[]> dfs(boolean[][] v, int[][] arr, int x, int y, int num){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        q.offer(new int[]{x, y});
        v[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            list.add(new int[]{now[0], now[1]});
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + d[i][0];
                int ny = now[1] + d[i][1];
                
                if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) continue;
                if(arr[nx][ny] == num && !v[nx][ny]){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return list;
    } 
    
    public List<int[]> normalizer(List<int[]> list){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        // 최솟값을 구하기
        for(int i = 0; i < list.size(); i++){
            minX = Math.min(list.get(i)[0], minX);
            minY = Math.min(list.get(i)[1], minY);
        }
        List<int[]> result = new ArrayList<>();
        for(int[] l : list){
            result.add(new int[]{l[0] - minX, l[1] - minY});
        }
        
        result.sort((a,b) -> {if(a[0] != b[0]) return a[0] - b[0]; return a[1] - b[1];});
        
        return result;
    }
    
    public List<int[]> rotate(List<int[]> list){
        List<int[]> result = new ArrayList<>();
        
        for(int[] l : list){
            result.add(new int[]{l[1], -l[0]});
        }
        
        return result;
    }
    
    public boolean match(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        
        for(int i = 0; i < a.size(); i++){
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        
        return true;
    }
}