import java.util.*;

class Solution {
    int[] parent = new int[2501];
    String[] child = new String[2501];
    
    // 부모를 찾아 떠남 현 2의 부모의 값을 찾아줌
    // 만약에 원래 parent[2] = 2를 가르키지만 병합 되면 parent[2] = 1처럼 합쳐진 곳을 가르킬 수 있음
    int find(int x){
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    // 병합할 때 x, y의 부모가 서로 다르면 parent[x] = x parent[y] = y일 때
    // y의 부모를 x로 향하게 함 parent[y] = x
    void union(int x, int y){
        if(x != y) parent[y] = x;
    }
    
    // 시작점은 1,1부터인데 여기서는 -1처리씩 해서 계산
    int toNum(String a, String b){
        return (Integer.parseInt(a) - 1) * 50 + (Integer.parseInt(b) - 1);
    }
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
             
        for(int i = 0; i < 2501; i++){
            parent[i] = i;
            child[i] = null;
        }
        
        for(String c : commands){
            String[] s = c.split(" ");
            
            if(s[0].equals("UPDATE")){
                if(s.length == 4){
                    int idx = toNum(s[1], s[2]);
                    child[find(idx)] = s[3];
                }
                else{
                    // 2500돌면서 value1의 값들을 싹다 value2의 값으로 변경
                    for(int i = 0 ; i< 2501; i++){
                        if(find(i) == i && child[i] != null && child[i].equals(s[1])) 
                            child[i] = s[2];
                    }
                }
            }
            
            // 합치기는 각 좌표의 최상단 부모값을 찾아옴
            // 거기서 값이 있냐없냐를 미리 구해놓고
            // union으로 합치기
            // 그 후에 앞의 좌표위치가 가르키는 child에 값 넣어주기
            else if(s[0].equals("MERGE")){
                int idx1 = toNum(s[1],s[2]);
                int idx2 = toNum(s[3],s[4]);
                
                int root1 = find(idx1);
                int root2 = find(idx2);
                
                if(root1 != root2){
                    String c1 = child[root1];
                    String c2 = child[root2];
                    
                    union(root1, root2);
                    
                    child[root1] = (c1 != null) ? c1 : c2;
                }
            }
            else if(s[0].equals("UNMERGE")){
                int idx = toNum(s[1], s[2]);
                int root = find(idx);
                String c1 = child[root];
                
                // 현 위치에 대한 부모 위치이 값 parent[idx] = 1
                // 1을 가르키고 있는 모든 표들을 기억하는거임
                List<Integer> cells = new ArrayList<>();
                for(int i = 0; i < 2501; i++){
                    if(find(i) == root){
                        cells.add(i);
                    }
                }
                
                // 해당 좌표들을 다 찾아서 다시 원래대로 돌려놓기
                for(int cell : cells){
                    parent[cell] = cell;
                    child[cell] = null;
                }
                
                child[idx] = c1;
            }
            else if(s[0].equals("PRINT")){
                int idx = toNum(s[1], s[2]);
                int root = find(idx);
                if(child[root] != null){answer.add(child[root]);}
                else{answer.add("EMPTY");}
            }
        }
        
        return answer.toArray(new String[0]);
    }
}