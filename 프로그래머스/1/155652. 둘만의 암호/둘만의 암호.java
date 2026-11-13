import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Set<Character> set = new HashSet<>();
        for(char c : skip.toCharArray()) set.add(c);
        for(char c : s.toCharArray()){
            // a를 가지고 index만큼 뒤로갈건데 그 사이에 만약에 skip에 포함되는 단어가 있으면 패스
            int idx = 0;
            while(idx < index){
                char next = (char)(c + 1);
                if(next > 'z') next = 'a';
                if(set.contains(next)) {
                    c = next;
                    continue;
                }
                else{
                    c = next;
                    idx++;
                }
            }
            answer += c;
        }
        return answer;
    }
}