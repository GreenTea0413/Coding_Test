import java.util.*;

class Solution {
    int n;
    int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        n = table.length;
        List<List<int[]>> gameBlock = new ArrayList<>();
        List<List<int[]>> tableBlock = new ArrayList<>();
        boolean[][] gameV = new boolean[n][n];
        boolean[][] tableV = new boolean[n][n];
        
        // 게임 보드의 빈칸 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!gameV[i][j] && game_board[i][j] == 0){
                    gameBlock.add(dfs(gameV, game_board, i, j, 0));
                }
            }
        }
        // 테이블 블록 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!tableV[i][j] && table[i][j] == 1){
                    tableBlock.add(dfs(tableV, table, i, j, 1));
                }
            }
        }
        
        // 조각 6개 비교해서 다 쓸 수 있는지
        boolean[] usedPiece = new boolean[tableBlock.size()];
        
        for(List<int[]> game : gameBlock){
            List<int[]> normBlank = normalizer(game);
            for(int i = 0; i < tableBlock.size(); i++){
                if(usedPiece[i]) continue;
                List<int[]> piece = tableBlock.get(i);
                boolean matched = false; 
                for(int r = 0; r < 4; r++){
                    List<int[]> normPiece = normalizer(piece);
                    if(match(normBlank, normPiece)){
                        usedPiece[i] = true;
                        answer += normBlank.size(); 
                        matched = true;
                        break;
                    }
                    piece = rotate(piece);
                }
                if(matched) break; 
            }
        }
        
        return answer;
    }
    
    public List<int[]> dfs(boolean[][] v, int[][] arr, int x, int y, int target){
        List<int[]> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        v[x][y] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            list.add(new int[]{now[0], now[1]});
            
            for(int i = 0; i < 4; i++){
                int nx = now[0] + d[i][0], ny = now[1] + d[i][1];
                
                if(0 <= nx && nx < n && 0 <= ny && ny < n){
                    if(!v[nx][ny] && arr[nx][ny] == target){
                        v[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        
        return list;
    }
    
    public List<int[]> normalizer(List<int[]> list){
        List<int[]> result = new ArrayList<>();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for(int[] l : list){
            minX = Math.min(l[0], minX);
            minY = Math.min(l[1], minY);
        }
        
        for(int[] l : list){
            result.add(new int[]{l[0] - minX, l[1] - minY});
        }
        result.sort((a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        return result;
    }
    
    List<int[]> rotate(List<int[]> group){
        List<int[]> result = new ArrayList<>();
        for(int[] p : group){
            result.add(new int[]{p[1], -p[0]});
        }
        return result;
    }
    
    boolean match (List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        
        for(int i = 0; i < a.size(); i++){
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        
        return true;
    }
}