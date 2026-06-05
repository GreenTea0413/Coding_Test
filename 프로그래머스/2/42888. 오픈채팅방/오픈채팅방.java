import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 고유번호랑 닉네임
        Map<String, String> name = new HashMap<>();
        for(String rec : record){
            String[] arr = rec.split(" ");
            
            if (!arr[0].equals("Leave")){
                name.put(arr[1], arr[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(String r : record){
            String[] words = r.split(" ");
            if(words[0].equals("Enter")){
                answer.add(name.get(words[1]) + "님이 들어왔습니다.");
            }
            else if(words[0].equals("Leave")){
                answer.add(name.get(words[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] result = new String[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}