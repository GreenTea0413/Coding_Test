class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        
        for(int i = 0; i < 5; i++){
            // 여기서 하나씩 시작
            String[] place = places[i];
            boolean check = true;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    // 여기서 이제 탐색을 하는데 탐색했을 때 P 8방향으로 비교
                    // 비교 했을 때 하나라도 P 걸리는거 있으면 false 반환
                    if(place[j].charAt(k) == 'P'){
                        if (!isCheck(place, j, k)){
                            check = false;
                            break;
                        }  
                    }
                }
                if (!check) {
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1},{1,1},{1,-1},{-1,1},{-1,-1}, {2,0}, {0,2}, {-2,0}, {0,-2}};
    public boolean isCheck(String[] place, int x, int y){
        for(int i = 0; i < 12; i++){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                if(place[nx].charAt(ny) == 'P'){
                    // 대각선이 아닌 곳에서 P가 나오면 바로 false
                    if(i < 4) return false;
                    
                    // 대각선이라면 테스트 해봐야함
                    // 오른쪽 아래
                    if (i == 4) {
                        if (place[nx - 1].charAt(ny) != 'X' || place[nx].charAt(ny - 1) != 'X'){
                            return false;
                        }
                    }
                    // 왼쪽 아래
                    if (i == 5) {
                        if (place[nx - 1].charAt(ny) != 'X' || place[nx].charAt(ny + 1) != 'X'){
                            return false;
                        }
                    }
                    // 오른쪽 위
                    if(i == 6){
                        if (place[nx].charAt(ny - 1) != 'X' || place[nx + 1].charAt(ny) != 'X'){
                            return false;
                        }
                    }
                    // 왼쪽 위
                    if(i == 7){
                        if (place[nx + 1].charAt(ny) != 'X' || place[nx].charAt(ny + 1) != 'X'){
                            return false;
                        }
                    }
                    // 직선 거리 2
                    if(i > 7){
                        int tx = x + d[i][0] / 2;
                        int ty = y + d[i][1] / 2;
                        if(place[tx].charAt(ty) != 'X') return false;
                    }
                }
            }
        }
        return true;
    }
}