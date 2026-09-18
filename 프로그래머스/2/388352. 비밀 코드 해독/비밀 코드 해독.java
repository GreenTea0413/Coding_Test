import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {        
        // 1 ~ n까지 5개씩 조합 만들어서 다 비교해보면 되는거임!
        combine(1, n, q, ans, new ArrayList<>());
        return answer;
    }
    
    public void combine(int start, int end, int[][] q, int[] ans, List<Integer> list){
        // 5개씩 채우면 비교하러가기
        if(list.size() == 5){
            if(isCheck(list, q, ans)) answer++;
            return;
        }
        
        for(int i = start; i <= end; i++){
            list.add(i);
            combine(i + 1, end, q, ans, list);
            list.remove(list.size() - 1);
        }
    }
    
    boolean isCheck(List<Integer> list, int[][] q, int[] ans){
        // 리스트로 만든 숫자 조합들로 ans에 정답 갯수랑 맞는지 비교하기
        for(int i = 0; i < q.length; i++){
            int count = 0;
            for(int num : q[i]){
                for(int l : list){
                    if(num == l) {count ++; break;}
                }   
            }
            if(count != ans[i]) return false;
        }
        return true;
    }
}