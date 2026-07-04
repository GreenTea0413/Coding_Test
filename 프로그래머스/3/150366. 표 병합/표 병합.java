import java.util.*;

class Solution {
    int[] parents = new int[2501];
    String[] values = new String[2501];
    
    public int find(int x){
        if(parents[x] == x){return x;}
        parents[x] = find(parents[x]);
        return parents[x];
    }
    
    public void union(int x, int y){
        if(x != y){parents[y] = x;}
    }
    
    public String[] solution(String[] commands) {
        for(int i = 0; i < 2500; i++){
            parents[i] = i;
            values[i] = null;
        }
        
        List<String> answer = new ArrayList<>();  
        for(String c : commands){
            String[] arr = c.split(" ");
            String com = arr[0];
            
            if(com.equals("UPDATE")){
                // r c value
                if(arr.length == 4){
                    int id = toNum(arr[1], arr[2]);
                    int root = find(id);
                    values[root] = arr[3];
                }
                
                // value1 value2
                else{
                    for(int i = 0; i < 2500; i++){
                        if(find(i) == i && values[i] != null && values[i].equals(arr[1])){
                            values[i] = arr[2];
                        }
                    }
                }
            }
            else if(com.equals("MERGE")){
                // r1 c1 r2 c2
                int id1 = toNum(arr[1], arr[2]);
                int id2 = toNum(arr[3], arr[4]);
                
                int root1 = find(id1);
                int root2 = find(id2);
                
                if(root1 != root2){
                    String v1 = values[root1];
                    String v2 = values[root2];
                    
                    union(root1, root2);
                    
                    values[root1] = (v1 != null) ?  v1 : v2;
                }
            }
            else if(com.equals("UNMERGE")){
                // r c
                int id = toNum(arr[1], arr[2]);
                int root = find(id);
                String v = values[root];
                List<Integer> cells = new ArrayList<>();
                
                for(int i = 0; i < 2500; i++){
                    if(find(i) == root){
                        cells.add(i);
                    }
                }
                
                for(int cell : cells){
                    parents[cell] = cell;
                    values[cell] = null;
                }
                values[id] = v;
            }
            else if(com.equals("PRINT")){
                // r c
                int id = toNum(arr[1], arr[2]);
                int root = find(id);
                if(values[root] == null){answer.add("EMPTY");}
                else answer.add(values[root]);
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    public int toNum(String x, String y){
        return (Integer.parseInt(x) - 1) * 50 + (Integer.parseInt(y) - 1);
    }
}