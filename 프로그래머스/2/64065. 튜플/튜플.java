import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        String temp = s.replace("},{", "a");
        String[] numbers = temp.substring(2, temp.length() - 2).split("a");
        
        for(int i = 0; i < numbers.length; i++){
            String[] num = numbers[i].split(",");
            for(int j = 0; j < num.length; j++){
                int n = Integer.parseInt(num[j]);
                map.put(n, map.getOrDefault(n, 0) + 1);    
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        // 1 2 3 4 키를 가지고 이제 정렬
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) ->{return map.get(b) - map.get(a);});
        
        for(int l : list) {
            answer.add(l);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}