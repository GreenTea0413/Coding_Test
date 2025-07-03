class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = strToInt(play_time);
        int advSec = strToInt(adv_time);
        long[] delta = new long[playSec + 1];
        
        for(String log : logs){
            String[] s = log.split("-");
            int start = strToInt(s[0]);
            int end = strToInt(s[1]);
            delta[start] ++;
            delta[end] --;
        }
        
        for(int i = 1; i < delta.length; i++){
            delta[i] = delta[i-1] + delta[i];
        }
        for(int i = 1; i < delta.length; i++){
            delta[i] = delta[i-1] + delta[i];
        }
        
        int start = 0;
        long max = delta[advSec-1];
        
        for(int i = 0; i < playSec - advSec + 1; i++){
            if(max < delta[i+advSec] - delta[i]){
                max = delta[i+advSec] - delta[i];
                start = i + 1;
            }
        }
        
        return intToStr(start);
    }
    
    
    int strToInt(String str){
        String[] sp = str.split(":");
        
        int h = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        int s = Integer.parseInt(sp[2]);
        
        return 3600 * h + 60 * m + s;
    }
    
    String intToStr(int s){
        String sec = String.valueOf(s % 60);
        if(sec.length() == 1) sec = "0" + sec;
        s = s /60;
        
        String min = String.valueOf(s % 60);
        if(min.length() == 1) min = "0" + min;
        s = s /60;
        
        String hour = String.valueOf(s);
        if(hour.length() == 1) hour = "0" + hour;
        
        return hour + ":" + min + ":" + sec;
    }
}