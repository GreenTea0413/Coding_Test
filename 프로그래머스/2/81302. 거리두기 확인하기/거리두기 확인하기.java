class Solution {
    int[][] d = {{0, 1}, {0,-1}, {1,0},{-1,0}};
    int[][] dt = {{1,1}, {-1,-1},{1,-1},{-1,1}};
    
    public int[] solution(String[][] places) {
        int len = places.length;
        int[] answer = new int[len];
        
        // 5 * 5
        // 좌표 비교했을 때 |r1 - r2| + |c1 - c2|
        // 기존의 상하좌우로 거르고
        // 대각선들은 있으면 거기에 맞게 x, y -> x + 1, y + 1에 사람있으면 (x ,y + 1) ,(x + 1, y)가 X인지
        for(int i = 0; i < len; i++){
            boolean check = true;
            char[][] arr = new char[5][5];
            
            for(int j = 0; j < 5; j++) arr[j] = places[i][j].toCharArray();
            
            // arr에 이제 다 담았으면 시작하기
            for(int x = 0; x < 5; x++){
                if(!check) break;
                for(int y = 0; y < 5; y++){
                    // 여기서 이제 주변 검사하는거임
                    if(!check) break;
                    
                    if(arr[x][y] == 'P'){
                        for(int k = 0; k < 4; k++){
                            int nx = x + d[k][0];
                            int ny = y + d[k][1];
                            
                            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                            
                            if(arr[nx][ny] == 'P') {
                                check = false;
                                break;
                            }
                            
                            int dx = nx + d[k][0];
                            int dy = ny + d[k][1];
                            
                            if(dx < 0 || dx >= 5 || dy < 0 || dy >= 5) continue;
                            
                            if(arr[dx][dy] == 'P' && arr[nx][ny] != 'X') {
                                check = false;
                                break;
                            }
                        }
                        
                        for(int k = 0; k < 4; k++){
                            int nx = x + dt[k][0];
                            int ny = y + dt[k][1];
                            
                            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                            
                            if(arr[nx][ny] == 'P'){
                                if(arr[nx][y] != 'X' || arr[x][ny] != 'X'){
                                    check = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(check) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
}