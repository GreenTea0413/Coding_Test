import java.util.*;

class Solution {
    int[][] d = {{1,0}, {0,-1},{0,1}, {-1,0}};
    String[] dir = {"d", "l", "r", "u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        int dist = Math.abs(x - r) + Math.abs(y - c);
        
        if(dist > k) return "impossible";
        if ((k - dist) % 2 == 1) return "impossible";
        
        // 이제 여기서 어떻게 갈지 계산
        while(k > 0){
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];

                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                int remain = k - 1;
                int nextDist = Math.abs(nx - r) + Math.abs(ny - c);

                if(remain >= nextDist && (remain - nextDist) % 2 == 0){
                    x = nx;
                    y = ny;
                    k --;
                    answer.append(dir[i]);
                    
                    break;
                }
            }
        }
        
        return answer.toString();
    }
}