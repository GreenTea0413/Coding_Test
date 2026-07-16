import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 일단 버스보다 사람 적으면 바로 반환
        int len = timetable.length;
        
        String answer = "";
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = toMin(timetable[i]);
        }
        Arrays.sort(arr);
        
        int idx = 0;
        int last = -1;
        // 버스는 n개만 옴 순환 되는 구조가 아님
        for(int i = 0; i < n; i++){
            // 그러면 이게 이제 배차 버스 시간
            // 처음에는 09:00이니까 540
            int time = i * t + 540;
            int count = 0;
            while(idx < len && count < m &&  arr[idx] <= time){
                last = arr[idx];
                count++;
                idx++;
            }
            
            if(i == n - 1){
                if(count < m){return toStr(time);}
                else{return toStr(last - 1);}
            }
        }
        
        
        return answer;
    }
    
    public int toMin(String str){
        String[] s = str.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    public String toStr(int num){
        int m = num % 60;
        int h = num / 60;
        
        return String.format("%02d:%02d", h,m);
    }
}