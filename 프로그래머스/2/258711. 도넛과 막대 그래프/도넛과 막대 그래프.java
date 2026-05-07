import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        // answer[0] = 생성 정점
        // answer[1] = 도넛 그래프 수
        // answer[2] = 막대 그래프 수
        // answer[3] = 8자 그래프 수
        
        // 정점 번호, 차수
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        // 정점들
        Set<Integer> nodes = new HashSet<>();
        
        // 차수 계산
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            
            // 이러면 out은 이제 정점 2에 대해서 3,1을 가니까 2개의 간선을 가지고 있다는 뜻
            // in은 3이 간선 2개 1이 간선 2개 가지고 있다는 뜻
            out.put(from, out.getOrDefault(from, 0) + 1);
            in.put(to, in.getOrDefault(to, 0) + 1);
            
            nodes.add(from);
            nodes.add(to);
        }
        
        int created = 0;
        int stick = 0;
        int eight = 0;
        
        for(int node : nodes){
            int inDegree = in.getOrDefault(node, 0);
            int outDegree = out.getOrDefault(node, 0);
            
            // 생성 정점
            // 들어오는게 하나도 없고 나가는것만 있으면 시작 정점
            // 왜 2냐면 그래프의 수의 합은 2 이상이여서 최소 2개부터 시작
            if(inDegree == 0 && outDegree >= 2){
                created = node;
            }
            
            // 막대 그래프 끝점
            // 끝점만 알면 되니까 어차피 그래프는 1개로 침
            // 들어오는게 1개고 나가는게 없으면 끝점
            // 오히려 반대로 들어오는게 없고 나가는게 있었다면 시작점이였을 거임
            else if(inDegree >= 1 && outDegree == 0){
                stick++;
            }
            
            // 8자 그래프 중심점
            // 그리고 8자 그래프는 
            else if(inDegree >= 2 && outDegree >= 2){
                eight++;
            }
        }
        
        int total = out.get(created);
        int donut = total - stick - eight;
        
        answer[0] = created;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
}