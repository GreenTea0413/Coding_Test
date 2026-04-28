import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int count = 0;
                int cur = i;

                while (!visited[cur]) {
                    visited[cur] = true;
                    cur = cards[cur] - 1; // 숫자 8을 뽑지만 그래도 8에 해당하는 idx로 가려먼 - 1
                    count++;
                }

                sizes.add(count);
            }
        }
        
        Collections.sort(sizes, Collections.reverseOrder());

        if (sizes.size() < 2) return 0;
        return sizes.get(0) * sizes.get(1);
    }
}