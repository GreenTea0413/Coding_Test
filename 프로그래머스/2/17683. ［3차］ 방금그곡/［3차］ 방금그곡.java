import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
        int len = musicinfos.length;
        String[][] music = new String[len][4];
        // # 붙은거 소문자로 처리
        m = convert(m);
        
        for(int i = 0; i < len; i++){
            String[] temp = musicinfos[i].split(",");
            for(int j = 0; j < 4; j++){
                music[i][j] = temp[j];
            }
        }
        
        Arrays.sort(music, (a, b) -> a[0].compareTo(b[0]));
        
        for(String[] arr : music){
            int start = toNum(arr[0]);
            int end = toNum(arr[1]);
            String name = arr[2];
            String melody = arr[3];
            melody = convert(melody);
            
            int gap = end - start;
            int ml = melody.length();

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < gap; i++){
                sb.append(melody.charAt(i % ml));
            }

            String tm = sb.toString();
            if(maxTime < gap && tm.contains(m)){
                maxTime = gap;
                answer = name;
            }
        }
        
        return answer;
    }
    
    public int toNum(String time){
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public String convert(String s){
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}