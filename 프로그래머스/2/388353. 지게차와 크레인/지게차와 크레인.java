import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        // 탈출 할 수 있는 것들의 좌표만 구하고
        // 빼는건 마지막에 한번에 하기
        // 끝 테두리를 비워놓기 그러면 좌표 0이랑 xLen + 1까지 가면 탈출 성공한거니까
        int xLen = storage.length;
        int yLen = storage[0].length();
        char[][] arr = new char[xLen + 2][yLen + 2];
        for(int i = 0; i < xLen + 2; i++) Arrays.fill(arr[i], '.');
        
        for(int i = 1; i <= xLen; i++){
            for(int j = 1; j <= yLen; j++){
                arr[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        for(String req : requests){
            char target = req.charAt(0);
            // 2개짜리는 그냥 다 없애버리면 됨
            if(req.length() == 2) {
                for(int i = 1; i <= xLen; i++){
                    for(int j = 1; j <= yLen; j++){
                        if(arr[i][j] == target){
                            arr[i][j] = '.';
                        }
                    }
                }
            }
            
            // 아니면 이제 여기서 탈출 가능한 exit에 여기오면 탈출 가능한 곳 정해놓기
            else{
                Queue<int[]> q = new LinkedList<>();
                boolean[][] exit = new boolean[xLen + 2][yLen + 2];
                q.offer(new int[]{0,0});
                exit[0][0] = true;
                
                while(!q.isEmpty()){
                    int[] now = q.poll();
                    
                    for(int i = 0; i < 4; i++){
                        int nx = now[0] + d[i][0];
                        int ny = now[1] + d[i][1];
                        
                        if(nx < 0 || nx >= xLen + 2 || ny < 0 || ny >= yLen + 2) continue;
                        if(exit[nx][ny]) continue;
                        
                        if(arr[nx][ny] == '.') {
                            exit[nx][ny] = true;
                            q.offer(new int[]{nx,ny});
                        }
                    }
                }
                
                // 그러면 이제 우리가 원래 값이 있는 범위에서 시작해서
                // 주변에 .이 있으면 삭제목록에 담기
                List<int[]> removeList = new ArrayList<>();
               for(int i = 1; i <= xLen; i++){
                    for(int j = 1; j <= yLen; j++){
                        if(arr[i][j] != target) continue;
                        
                        for(int k = 0; k < 4; k++){
                            int nx = i + d[k][0];
                            int ny = j + d[k][1];
                            
                            if(exit[nx][ny]){
                                removeList.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
                
                for(int[] rl : removeList){
                    arr[rl[0]][rl[1]] = '.';
                }
            }
        }
        
        for(int i = 1; i <= xLen; i++){
            for(int j = 1; j <= yLen; j++){
                if(arr[i][j] != '.') answer++;
            }
        }
        
        return answer;
    }
}