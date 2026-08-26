import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        int turn = 1;
        int user = 1;
        String w = words[0];
        set.add(w);
        
        for(int i = 1; i < words.length; i++){
            // 집합에 없고 w 끝말이랑 words[i] 첫단어가 같으면 ok
            if(!set.contains(words[i]) && w.charAt(w.length() - 1) == words[i].charAt(0)){
                set.add(words[i]);
                w = words[i];
                user++;
                // user가 n이랑 같아지면 다시 1로 보내기
                if(user == n) { user = 0; turn ++;}
            }
            else{
                return new int[]{user + 1, turn};
            }
        }
        
        return answer;
    }
}