import java.util.*;

class Solution {
    // 조합
    int col;
    int[] batch;
    int answer = 0;
    List<Set<Integer>> candidateKeys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        col = relation[0].length;
        batch = new int[col];
        for(int i = 0; i < col; i++){batch[i] = i;}
        
        // 속성 갯수만큼 조합 만드는 거임
        for(int i = 1; i <= col; i++){
            combine(0, i, new ArrayList<>(), relation);    
        }
        return answer;
    }
    
    public void combine(int start, int end, List<Integer> list, String[][] relation){
        if(list.size() == end){
            if(!isMinimal(list)) return;
            if (isUnique(list, relation)){
                answer++;
                candidateKeys.add(new HashSet<>(list));
            };
            return;
        }
        
        for(int i = start; i < col; i++){
            list.add(batch[i]);
            combine(i + 1, end, list, relation);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isMinimal(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        for(Set<Integer> key : candidateKeys){
            if(set.containsAll(key)) return false;
        }
        return true;
    }
    public boolean isUnique(List<Integer> list, String[][] relation){
        Set<String> set = new HashSet<>();
        
        for(String[] row : relation){
            StringBuilder sb = new StringBuilder();
            for(int l : list){
                sb.append(row[l]).append(",");
            }
            set.add(sb.toString());
        }
        return set.size() == relation.length;
    }
}