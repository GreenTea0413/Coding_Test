import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        // 30개 중 5개 조합으로 다 비교하기
        comb(1, n, q, ans, new ArrayList<>());
        return answer;
    }
    
    public void comb(int start, int end, int[][] q, int[] ans, List<Integer> list){
        if(list.size() == 5){
            if(isValid(list, q, ans)){
                answer++;
                return;
            }
        }
        
        for(int i = start; i <= end; i++){
            list.add(i);
            comb(i + 1, end, q, ans, list);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> list, int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int count = 0;
            for(int num : list){
                for(int x : q[i]){
                    if(num == x) count++;
                }
            }
            
            if(count != ans[i]) return false;
        }
        
        return true;
    }
}