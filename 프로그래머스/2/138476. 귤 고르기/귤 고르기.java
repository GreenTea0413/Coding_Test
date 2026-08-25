import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        // 서로 다른 종류의 수의 최솟값
        List<int[]> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(new int[]{key, map.get(key)});
        }
        list.sort((a, b) -> (b[1] - a[1]));
        
        // 1 4개 2 3개 3 1개
        // k = 2개만 담을거다
        int answer = 0;
        for(int i = 0; i < list.size(); i++){
            k -= list.get(i)[1];
            if(k <= 0) {
                answer++;
                break;
            }
            answer++;
        }
        
        return answer;
    }
}