import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = (int)toNum(play_time);
        int adv = (int)toNum(adv_time);
        long[] arr = new long[play + 1];
        
        for(String log : logs){
            String[] s = log.split("-");
            int start = (int)toNum(s[0]);
            int end = (int)toNum(s[1]);
            
            arr[start] ++;
            arr[end] --;
        }
        
        // 누적합으로 시청하는 사람 구하기
        for(int i = 1; i <= play; i++){
            arr[i] += arr[i - 1];
        }
        // 누적합으로 시간 구하기
        for(int i = 1; i <= play; i++){
            arr[i] += arr[i - 1];
        }
        
        long max = arr[adv - 1];
        long startTime = 0;
        
        for(int end = adv; end < play; end++){
            long cur = arr[end]  - arr[end - adv];
            
            if(cur > max){
                max = cur;
                startTime = end - adv + 1;
            }
        }
        
        int h = (int)(startTime / 3600);
        int m = (int)(startTime % 3600) / 60;
        int s = (int)(startTime % 60);
        
        return String.format("%02d:%02d:%02d",h,m,s);
    }
    
    public long toNum(String s){
        String[] st = s.split(":");
        
        return Long.parseLong(st[0]) * 3600 + Long.parseLong(st[1]) * 60 + Long.parseLong(st[2]);
    }
}