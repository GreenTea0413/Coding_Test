import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        // C, C#, D, D#, E, F, F#, G, G#, A, A#, B
        // #들어가있으면 문자 비교하기 어려우니까 소문자로 바꾸기

        // #까지 잘 봐야하는 문제
        m = convert(m);
        
        int max = -1;
        for(String mu : musicinfos){
            // 시작, 끝, 제목, 코드
            String[] s = mu.split(",");
            int start = toMin(s[0]);
            int end = toMin(s[1]);
            String title = s[2];
            String melody = convert(s[3]);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < end - start; i++) sb.append(melody.charAt(i % melody.length()));
            
            // 비교를 처음부터 해도 되는가?
            int len = m.length();
            if(len > sb.length()) continue;
            
            // 이제 여기서 #비교를 해야함
            if(sb.toString().contains(m)) {
                if(end - start > max) {
                    max = end - start;
                    answer = title;
                }   
            }
        }
        return answer;
    }
    
    int toMin(String str){
        String[] s = str.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    String convert(String str){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == '#') continue;
            
            if(str.charAt(i + 1) == '#'){
                if(str.charAt(i) == 'A') sb.append('a');
                if(str.charAt(i) == 'C') sb.append('c');
                if(str.charAt(i) == 'D') sb.append('d');
                if(str.charAt(i) == 'E') sb.append('e');
                if(str.charAt(i) == 'F') sb.append('f');
                if(str.charAt(i) == 'G') sb.append('g');
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        if(str.charAt(str.length() - 1) != '#') sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }
}