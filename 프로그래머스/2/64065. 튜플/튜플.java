import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        s = s.replace("},{", "a");
        
        String[] arr1 = s.split("a");
        
        for(String a : arr1){
            String[] arr2 = a.split(",");
            for(String b : arr2){
                int n = Integer.parseInt(b);
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        List<int[]> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(new int[]{key, map.get(key)});
        }
        
        list.sort((a, b) -> (b[1] - a[1]));
        int[] answer = new int[map.size()];
        int idx = 0;
        for(int[] l : list) { answer[idx] = l[0]; idx++; }
        return answer;
    }
}