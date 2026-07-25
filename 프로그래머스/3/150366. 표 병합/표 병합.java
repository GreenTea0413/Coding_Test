import java.util.*;

class Solution {
    int[] parent = new int[2501];
    String[] child = new String[2501];
    
    int find (int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    void union(int x, int y){
        if(x != y) parent[y] = x;
    }
    
    int toNum(String x, String y){
        return (Integer.parseInt(x) - 1) * 50 + (Integer.parseInt(y) - 1);
    }
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 2500; i++){
            parent[i] = i;
            child[i] = null;
        }
        for(String c : commands){
            String[] arr = c.split(" ");
            
            if(arr[0].equals("UPDATE")){
                if(arr.length == 4){
                    int id = toNum(arr[1], arr[2]);
                    child[find(id)] = arr[3];
                }
                else{
                    for(int i = 0; i < 2501; i++){
                        if(find(i) == i && child[i] != null && child[i].equals(arr[1])){
                            child[i] = arr[2];
                        }
                    }
                }
            }
            else if(arr[0].equals("MERGE")){
                int idx1 = toNum(arr[1], arr[2]);
                int idx2 = toNum(arr[3], arr[4]);
                
                int root1 = find(idx1);
                int root2 = find(idx2);
                
                if(root1 != root2){
                    String c1 = child[root1];
                    String c2 = child[root2];
                    
                    union(root1, root2);
                    
                    child[root1] = (c1 != null) ? c1 : c2;
                }
            }
            else if(arr[0].equals("UNMERGE")){
                int idx1 = toNum(arr[1], arr[2]);
                int root = find(idx1);
                String c1 = child[root];
                
                List<Integer> cells = new ArrayList<>();
                for(int i = 0; i < 2501; i++){
                    if(find(i) == root){
                        cells.add(i);
                    }
                }
                
                for(int cell : cells){
                    parent[cell] = cell;
                    child[cell] = null;
                }
                child[idx1] = c1;
            }
            else if(arr[0].equals("PRINT")){
                int idx = toNum(arr[1], arr[2]);
                int root = find(idx);
                if(child[root] != null){answer.add(child[root]);}
                else{answer.add("EMPTY");}
            }
            
        }
        return answer.toArray(new String[0]);
    }
}