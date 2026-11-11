class Solution {
    public int[] solution(String[] wallpaper) {
        int xLen = wallpaper.length;
        int yLen = wallpaper[0].length();
        
        int lux = Integer.MAX_VALUE; int luy = Integer.MAX_VALUE; int rdx = 0; int rdy = 0;
        
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    // 같이 비교 했을 때 둘 다 작거나 같으면? 근데 애초에 왼쪽 위부터 보기 때문에
                    lux = Math.min(lux,i);
                    luy = Math.min(luy,j);
                    
                    rdx = Math.max(rdx,i + 1);
                    rdy = Math.max(rdy,j + 1);
                }
            }
        }
        int[] answer = new int[4];
        answer[0] = lux; answer[1] = luy; answer[2] = rdx; answer[3] = rdy; 
        return answer;
    }
}