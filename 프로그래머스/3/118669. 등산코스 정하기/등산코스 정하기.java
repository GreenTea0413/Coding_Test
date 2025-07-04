import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Set<Integer> summitSet = Arrays.stream(summits).boxed().collect(Collectors.toSet());
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] path : paths) {
            graph.computeIfAbsent(path[0], k -> new ArrayList<>()).add(new int[]{path[1], path[2]});
            graph.computeIfAbsent(path[1], k -> new ArrayList<>()).add(new int[]{path[0], path[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int g : gates) {
            dist[g] = 0;
            pq.add(new int[]{0, g});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int inten = cur[0], node = cur[1];
            if (dist[node] < inten || summitSet.contains(node)) continue;
            for (int[] next : graph.getOrDefault(node, List.of())) {
                int ni = Math.max(inten, next[1]);
                if (dist[next[0]] > ni) {
                    dist[next[0]] = ni;
                    pq.add(new int[]{ni, next[0]});
                }
            }
        }

        Arrays.sort(summits);
        int minNode = 0, minIntensity = Integer.MAX_VALUE;
        for (int s : summits) {
            if (dist[s] < minIntensity) {
                minNode = s;
                minIntensity = dist[s];
            }
        }

        return new int[]{minNode, minIntensity};
    }
}