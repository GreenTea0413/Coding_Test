class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int total = toMin(video_len);
        int now = toMin(pos);
        int op_s = toMin(op_start);
        int op_e = toMin(op_end);
        if(op_s < now && now < op_e) now = op_e;
        
        for(String s : commands){
            if(s.equals("prev")){
                now -= 10;
                if(now < 0) now = 0;
                
            }
            else{
                now += 10;
                if(now > total) now = total;
            }
            if(op_s <= now && now < op_e) now = op_e;
        }
        int m = now / 60;
        int s = now % 60;
        return String.format("%02d:%02d", m, s);
    }
    
    int toMin(String s){
        String[] str = s.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}