import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (String s : operations) {

            String[] c = s.split(" ");

            if (c[0].equals("I")) {
                int num = Integer.parseInt(c[1]);
                min_pq.offer(num);
                max_pq.offer(num);
            }

            else if (c[0].equals("D")) {

                if (min_pq.isEmpty()) continue;

                if (c[1].equals("1")) {        // 최댓값 삭제
                    int max = max_pq.poll();
                    min_pq.remove(max);       // 동기화
                }

                else {                        // 최솟값 삭제
                    int min = min_pq.poll();
                    max_pq.remove(min);       // 동기화
                }
            }
        }

        if (min_pq.isEmpty())
            return new int[]{0, 0};

        return new int[]{max_pq.peek(), min_pq.peek()};
    }
}