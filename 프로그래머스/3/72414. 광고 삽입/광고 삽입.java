import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {        
        // 플레이 타임을 초로 바꿔서 배열 크기로 정하기
        int p = (int)toSec(play_time);
        int a = (int)toSec(adv_time);
        long[] pArr = new long[p + 1];
        // 누적합으로 처음과 끝에 값을 넣어서 배열에 +1 -1을 기준 세우기
        for(String l : logs){
            String[] s = l.split("-");
            
            int start = (int)toSec(s[0]);
            int end = (int)toSec(s[1]);
            
            pArr[start] += 1;
            pArr[end] -= 1;
        }
        
        // 그 다음 가장 많이 시청하는 곳에서 광고 넣기!
        for(int i = 1; i <= p; i++) pArr[i] += pArr[i - 1];
        for(int i = 1; i <= p; i++) pArr[i] += pArr[i - 1];
        
        // pArr에 광고 플레이 타임을 
        long max = pArr[a - 1];
        long startAdv = 0;
        
        for(int i = a; i < p; i++){
            long cur = pArr[i] - pArr[i - a];
            
            if(cur > max){
                max = cur;
                startAdv = i - a + 1;
            }
        }
        
        String answer = "";
        int h = (int)startAdv / 3600;
        int m = (int)startAdv % 3600 / 60;
        int s = (int)startAdv % 60;
        
        return String.format("%02d:%02d:%02d",h,m,s);
    }
    
    long toSec(String str){
        String[] s = str.split(":");
        return Long.parseLong(s[0]) * 3600 +  Long.parseLong(s[1]) * 60 +  Long.parseLong(s[2]);
    }
}