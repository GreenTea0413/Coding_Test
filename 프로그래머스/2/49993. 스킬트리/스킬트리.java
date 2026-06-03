import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] sk = skill.split("");
        int len = skill_trees.length;
        
        for(int i = 0; i < len; i++){
            String[] st = skill_trees[i].split("");
            
            Queue<String> q = new LinkedList<>();
            for(String k : sk){q.offer(k);}
            
            boolean check = true;
            for(String t : st){
                if(!q.contains(t)) continue;
                else{
                    if(q.peek().equals(t)){
                        q.poll();
                    }
                    else{
                        check = false;
                        break;
                    }
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}