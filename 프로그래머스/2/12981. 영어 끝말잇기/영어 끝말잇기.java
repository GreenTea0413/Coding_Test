import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        // 단어 기록
        Map<String, Integer> map = new HashMap<>();
        // 끝 단어 기록
        String lastWord = String.valueOf(words[0].charAt(words[0].length() - 1));
        map.put(words[0], 1);
        int count = 1;
        
        for(int i = 1; i < words.length; i++){
            // 다음 시작언어
            String startWord = String.valueOf(words[i].charAt(0));
            
            // 같지 않음!!
            if(!lastWord.equals(startWord)){return new int[]{count % n + 1, count / n + 1};}
            // 같을 때
            else if(lastWord.equals(startWord)){
                // 맵에도 없으면 횟수 추가에 map에 넣기, 끝말 단어 바꿔주기
                if(!map.containsKey(words[i])){
                    count++;
                    map.put(words[i], 1);
                    lastWord = String.valueOf(words[i].charAt(words[i].length() - 1));
                }
                else{
                    return new int[]{count % n + 1, count / n + 1};
                }
            }
        }
        return new int[]{0,0};
    }
}