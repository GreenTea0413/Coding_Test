import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // CBD
        // 스킬트리를 BACDE로 한다면? 안된다
        // 만약에 CBD가 일단 Set에 넣어 놓고 CBADF랑 비교한다면
        // C가 set에 있고 지금 idx = 0이라면 ㅇㅋ
        // B가 set에 있고 지금 idx = 1이라면 ㅇㅋ
        // A는 set에 없으니까 배우던 말던
        Set<Character> set = new HashSet<>();
        for(char c : skill.toCharArray()) set.add(c);
        
        
        for(int i = 0; i < skill_trees.length; i++){
            int idx = 0;
            String s = skill_trees[i];
            boolean check = true;
            // BACDE
            for(char c : s.toCharArray()){
                if(set.contains(c)){
                    if(skill.charAt(idx) == c) idx++;
                    else { check = false; break; }
                }
            }
            if(check) answer++;
        }
        
        
        
        return answer;
    }
}