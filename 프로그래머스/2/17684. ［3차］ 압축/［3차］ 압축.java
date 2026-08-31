import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        // 그러면 이제 문자를 하나씩 꺼내는데 그 다음게 만약에 없으면 넣고
        // 있으면 추가한다?
        // 그러면 문자 하나 다음에 또 추가하기 위해서 while로 비교하기?
        int len = msg.length();
        int count = 27;
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < len; i++){
            // K가 있으면 만약에 map에 있다? 그러면 일단 해당 값을 11을 넣어야하는가?
            // 아니다 그러면 다다음에 K가 왔을 때 KA 검증 없이 바로 넣어버린다.
            String next = "" + msg.charAt(i);
            
            // 이건 이제 KA나 KAO처럼 새로운 사전 추가하는거
            while(i + 1 < len && map.containsKey(next + msg.charAt(i + 1))){
                next = next + msg.charAt(i + 1);
                i++;
            }
            
            if(map.containsKey(next)) answer.add(map.get(next));
            if(i + 1 < len) {
                map.put(next + msg.charAt(i + 1), count);
                count++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}