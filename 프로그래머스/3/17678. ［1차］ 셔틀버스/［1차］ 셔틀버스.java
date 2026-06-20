import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int people = timetable.length;
        
        int[] time = new int[people];
        for(int i = 0; i < people; i++){time[i] = toNum(timetable[i]);}
        
        Arrays.sort(time);
        
        int idx = 0;
        int last = -1;
        
        for(int bus = 0; bus < n; bus++){
            int busTime = 540 + bus * t;
            int count = 0;
            while(idx < people && count < m && time[idx] <= busTime){
                last = time[idx];
                idx ++;
                count++;
            }
            
            if(bus == n - 1){
                if (count < m) {
                    return toString(busTime);

                }
                return toString(last - 1);
            }
        }

        return "";
    }
    
    public int toNum(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public String toString(int n){
        int h = n / 60;
        int m = n % 60;
        
        return String.format("%02d:%02d", h, m);
    }
}