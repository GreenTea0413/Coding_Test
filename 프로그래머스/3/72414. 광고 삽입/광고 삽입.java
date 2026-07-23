class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = (int)toNum(play_time);
        int adv = (int)toNum(adv_time);
        
        long[] arr = new long[play + 1];
        int len = logs.length;
        
        for(int i = 0; i < len; i++){
            String[] l = logs[i].split("-");
            int start = (int) toNum(l[0]);
            int end = (int) toNum(l[1]);
            
            arr[start]++;
            arr[end]--;
        }
        
        for(int i = 1; i <= play; i++){
            arr[i] += arr[i-1];
        }
        
        for(int i = 1; i<= play; i++){
            arr[i] += arr[i-1];
        }
        
        long max = arr[adv - 1];
        long startTime = 0;
        
        for(int i = adv; i < play; i++){
            long cur = arr[i] - arr[i - adv];
            
            // 누적 시간이 더 크다!
            if(cur > max){
                max = cur;
                startTime = i - adv + 1;
            }
        }
        
        // startTime = 6030
        int h = (int) startTime / 3600;
        int m = (int) startTime % 3600 / 60;
        int s = (int) startTime % 60;
        
        return String.format("%02d:%02d:%02d", h,m,s);
    }
    long toNum(String s){
        String[] arr = s.split(":");
        return Long.parseLong(arr[0]) * 3600 + Long.parseLong(arr[1]) * 60 + Long.parseLong(arr[2]);
    }
}