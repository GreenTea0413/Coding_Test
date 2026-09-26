import java.util.*;

class Solution {
    // 사전순으로 먼저 움직이도록 해야함
    // d l r u
    int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
    String[] alp = {"d","l","r","u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {        
        int min = Math.abs(x - r) + Math.abs(y - c);
        
        if(min > k) return "impossible"; // 최소 이동길이보다 k가 작으면 못감
        if((k - min) % 2 != 0) return "impossible"; // k까지 갈때 min을 빼고 홀수면 못감
        
        StringBuilder sb = new StringBuilder();
        // 좌표 1,1부터 시작해서 n, m까지
        while(k > 0){
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                
                int dist = Math.abs(r - nx) + Math.abs(c - ny);
                int remain = k - 1;
                
                if(remain < dist) continue;
                if((remain - dist) % 2 != 0) continue;
                
                x = nx; y = ny;
                sb.append(alp[i]);
                k--;
                break;
            }
        }
        
        return sb.toString();
    }
}