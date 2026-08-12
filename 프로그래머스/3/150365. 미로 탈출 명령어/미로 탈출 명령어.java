class Solution {
    int[][] d = {{1,0}, {0,-1},{0,1},{-1,0}};
    String[] dir = {"d", "l", "r", "u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int min = Math.abs(x - r) + Math.abs(y - c);
        int[][] map = new int[n + 1][m + 1];
    
        if(min > k) return "impossible";
        if((k - min) % 2 != 0) return "impossible";
        
        StringBuilder sb = new StringBuilder();
        while(k > 0){
            for(int i = 0; i < 4; i++){
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                
                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                
                int dist = Math.abs(r - nx) + Math.abs(c - ny);
                int remain = k - 1;

                if((k - dist) % 2 == 0 || remain >= dist) {
                    x = nx; y = ny;
                    sb.append(dir[i]);
                    k--;
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}