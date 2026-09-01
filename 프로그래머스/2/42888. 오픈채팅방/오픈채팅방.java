import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 유저 uid와 이름을 저장할 map
        Map<String, String> nameMap = new HashMap<>();
        
        for(String rec : record){
            String[] arr = rec.split(" ");
            
            String cmd = arr[0];
            if(cmd.equals("Leave")) continue;
            
            String uid = arr[1];
            String name = arr[2];
            nameMap.put(uid, name);
        }
        
        List<String> answer = new ArrayList<>();
        
        for(String rec : record){
            String[] arr = rec.split(" ");
           
            String cmd = arr[0];
            String uid = arr[1];
            String temp = "";
            if(cmd.equals("Enter")) {temp += nameMap.get(uid) + "님이 들어왔습니다.";answer.add(temp);}
            else if(cmd.equals("Leave")) {temp += nameMap.get(uid) + "님이 나갔습니다.";answer.add(temp);}
            
        }
        
        return answer.toArray(new String[0]);
    }
}