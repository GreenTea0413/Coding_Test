import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int len = timetable.length;
        int[] arr = new int[len];
        
        // 사람들 시간순으로 정렬
        for(int i = 0; i < len; i++){
            arr[i] = toNum(timetable[i]);
        }
        Arrays.sort(arr);
        
        // 버스 하나마다 사람들 다 태워서보내기
        // 근데 여기서 버스 마지막에 도달하면 무조건 그 사람 내보내야하기 때문에
        // 마지막 사람 보다 -1만큼만 하기
        
        int idx = 0;
        int last = -1;
        for(int i = 0; i < n; i++){
            int time = i * t + 540;
            int count = 0; // 한 버스에 몇명
            while(idx < len && arr[idx] <= time && count < m){
                last = arr[idx];
                idx++;
                count++;
            }
            
            if(i == n - 1){
                // 마지막 버스일 때 사람이 꽉 안차면 버스 도착하자마자 타는게 늦는거 중에 빠름
                if(count < m) return toString(time);
                // 그리고 사람 덜찾으면 젤 마지막 사람보다 -1만큼 빠르게 타면 됨
                else return toString(last - 1);
            }
        }
        
        return answer;
    }
    
    int toNum(String str){
        String[] s = str.split(":");
        
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    String toString(int num){
        int h = num / 60;
        int m = num % 60;
        
        return String.format("%02d:%02d", h,m);
    }
}