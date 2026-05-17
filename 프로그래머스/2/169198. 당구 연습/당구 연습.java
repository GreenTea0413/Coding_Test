class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++){
            int bx = balls[i][0];
            int by = balls[i][1];
            int minD = Integer.MAX_VALUE;
            
            // 상단 벽 대칭: (bx, -by)
            // x좌표 같으면 직선 통과 → 제외
            if(startX != bx){
                int dx = startX - bx;
                int dy = startY - (-by);
                minD = Math.min(minD, dx*dx + dy*dy);
            }
            
            // 하단 벽 대칭: (bx, 2n - by)
            if(startX != bx){
                int dx = startX - bx;
                int dy = startY - (2*n - by);
                minD = Math.min(minD, dx*dx + dy*dy);
            }
            
            // 좌측 벽 대칭: (-bx, by)
            // y좌표 같으면 직선 통과 → 제외
            if(startY != by){
                int dx = startX - (-bx);
                int dy = startY - by;
                minD = Math.min(minD, dx*dx + dy*dy);
            }
            
            // 우측 벽 대칭: (2m - bx, by)
            if(startY != by){
                int dx = startX - (2*m - bx);
                int dy = startY - by;
                minD = Math.min(minD, dx*dx + dy*dy);
            }
            
            // 같은 선상이면 직선으로 벽에 부딪히고 오는것도 계산
            if(startX == bx){
                // 칠거 (7,9) , 맞혀야하는거 (7,7)
                if(startY > by){
                    int gap = n - startY + n - by;
                    minD = Math.min(gap * gap, minD);
                }
                // 칠거 (7,7) , 맞혀야하는거 (7,9)
                if(startY < by){
                    int gap = startY + by;
                    minD = Math.min(gap * gap, minD);
                }
            }
            
            if(startY == by){
                // 칠거 (9,7) , 맞혀야하는거 (7,7)
                if(startX > bx){
                    int gap = m - startX + m - bx;
                    minD = Math.min(gap * gap, minD);
                }
                // 칠거 (4,7) , 맞혀야하는거 (7,9)
                if(startX < bx){
                    int gap = startX + bx;
                    minD = Math.min(gap * gap, minD);
                }
            }
            
            answer[i] = minD;
        }
        return answer;
    }
}