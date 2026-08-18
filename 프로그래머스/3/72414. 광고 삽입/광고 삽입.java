class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";        
        // 100 * 3600
        // 누적합 문제
        int play = (int)toNum(play_time);
        int adv = (int)toNum(adv_time);
        long[] dp = new long[play + 1];
        
        // 이 문제는 int로 하면 오버플로우 발생함
        for(String log : logs){
            String[] l = log.split("-");
            int start = (int)toNum(l[0]);
            int end = (int)toNum(l[1]);
            
            dp[start]++;
            dp[end]--;
        }
        
        for(int i = 1; i <= play; i++){
            dp[i] += dp[i - 1];
        }
        for(int i = 1; i <= play; i++){
            dp[i] += dp[i - 1];
        }
        
        long max = dp[adv - 1];
        long startTime = 0;
        
        for(int i = adv; i < play; i++){
            long cur = dp[i] - dp[i - adv];
            
            if(cur > max){
                max = cur;
                startTime = i - adv + 1;
            }
        }
        
        int h = (int) startTime / 3600;
        int m = (int) startTime % 3600 / 60;
        int s = (int) startTime % 60;
        
        return String.format("%02d:%02d:%02d", h,m,s);
    }
    
    long toNum(String str){
        String[] s = str.split(":");
        return Long.parseLong(s[0]) * 3600 + Long.parseLong(s[1]) * 60 + Long.parseLong(s[2]);
    }
}