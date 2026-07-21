import java.util.*;

class Solution {
    int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    String[] d = {"d", "l", "r", "u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        // 일단 바로 갔을 때의 거리
        int dist = Math.abs(r - x) + Math.abs(c - y);
        if(dist > k) return "impossible"; // 거리가 k보다 길면 못가니까
        if((k - dist) % 2 == 1) return "impossible"; // 이게 거리가 아무리 된다고 해도 홀수면 못감
        
        while(k > 0){
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                int remain = k - 1;
                int nextDist = Math.abs(r - nx) + Math.abs(c - ny);
                
                if(nextDist <= remain && (remain - nextDist) % 2 == 0){
                    x = nx;
                    y = ny;
                    k--;
                    answer.append(d[i]);
                    
                    break;
                }
            }
        }
        return answer.toString();
    }
}