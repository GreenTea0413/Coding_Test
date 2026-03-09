import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    int[] courseArr;
    
    public String[] solution(String[] orders, int[] course) {
        courseArr = course;
        List<String> answer = new ArrayList<>();
        
        for (String order : orders) {
            // 각 주문을 정렬 (사전순 조합을 위해)
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            // course 크기별 조합 생성
            for (int c : course) {
                combine(chars, "", 0, c);
            }
        }
        
        // course 크기별 최대값 추출
        for (int c : course) {
            int max = 1; // 최소 2번 이상이어야 하므로 기준을 1로
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().length() == c) {
                    max = Math.max(max, entry.getValue());
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().length() == c && entry.getValue() == max && max >= 2) {
                    answer.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void combine(char[] chars, String current, int start, int depth) {
        if (depth == 0) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        for (int i = start; i < chars.length; i++) {
            combine(chars, current + chars[i], i + 1, depth - 1);
        }
    }
}