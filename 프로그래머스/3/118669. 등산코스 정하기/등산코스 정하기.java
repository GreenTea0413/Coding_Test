import java.util.*;

class Solution {
    class Node{
        int to;
        int intensity;
        
        Node(int to, int intensity){
            this.to = to;
            this.intensity = intensity;
        }
    }
    
    // 그래프 만들어 놓기
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] graph = new ArrayList[n + 1];    
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] p : paths){
            graph[p[0]].add(new Node(p[1], p[2]));
            graph[p[1]].add(new Node(p[0], p[2]));
        }
        
        // 한번 이동할 때의 최대 이동길이가 가장 짧은 것을 구하고 거기에 도착한 산봉우리 번호
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {return a.intensity - b.intensity;});
        
        Set<Integer> sumSet = new HashSet<>();
        for(int sum : summits){sumSet.add(sum);}
        
        int[] inten = new int[n + 1];
        Arrays.fill(inten, Integer.MAX_VALUE);
        
        for(int g : gates){
            inten[g] = 0;
            pq.offer(new Node(g, 0));
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.intensity > inten[cur.to]) continue;
            if(sumSet.contains(cur.to)) continue;
            
            for(Node next : graph[cur.to]){
                int nextIntensity = Math.max(next.intensity, cur.intensity);
                
                if(nextIntensity < inten[next.to]){
                    inten[next.to] = nextIntensity;
                    pq.offer(new Node(next.to, nextIntensity));
                }
                
            }
        }
        
        Arrays.sort(summits);
        int summitNum = 0;
        int minIntensity = Integer.MAX_VALUE;
        
        for(int sum : summits){
            if(inten[sum] < minIntensity){
                summitNum = sum;
                minIntensity = inten[sum];
            }
        }
        
        return new int[]{summitNum, minIntensity};
    }
}