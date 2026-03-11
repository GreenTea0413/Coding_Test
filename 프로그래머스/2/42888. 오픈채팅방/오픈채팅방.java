import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        // 유저 아이디, 닉네임
        Map<String, String> map = new HashMap<>();
        
        for(String r : record){
            String[] words = r.split(" ");
            
            if (words[0].equals("Enter")){
                map.put(words[1], words[2]);
            }
            else if (words[0].equals("Change")){
                map.put(words[1], words[2]);
            }
        }
        
        for(String r : record){
            String[] words = r.split(" ");
            
            if (words[0].equals("Enter")){
                answer.add(map.get(words[1]) + "님이 들어왔습니다.");
            }
            else if (words[0].equals("Leave")){
                answer.add(map.get(words[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] result = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}
