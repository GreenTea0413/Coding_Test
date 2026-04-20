import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] sk = skill.split("");
        
        for(String st : skill_trees){
            String[] arr = st.split("");
            
            Queue<String> q = new LinkedList<>();
            for(String k : sk){q.offer(k);}
            
            // 여기까지 하면
            // 큐에는 C B D가 순서대로
            // B A C D E를 하나씩 꺼내서 비교할거임
            // 1. 큐에 해당 알파벳이 없으면 그냥 넘어가면 됨
            // 2. 큐에 해당 알파벳이 있으면 
            //  2-1. q.peek()에 그 값이 있으면 큐에서 poll하고 다음 값 찾으면 됨
            //  2-2. q.peek()에 그 값이 없으면 break; 다음 스킬트리로 넘어가야함
            boolean isCheck = true;
            for(String s : arr){
                if(!q.contains(s)){continue;}
                else{
                    if(q.peek().equals(s)){q.poll();}
                    else {isCheck = false; break;}
                }                
            }
            if (isCheck) answer++;
        }
        
        return answer;
    }
}