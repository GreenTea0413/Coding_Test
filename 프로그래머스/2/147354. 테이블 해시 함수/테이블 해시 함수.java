import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // 테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬
        Arrays.sort(data, (a, b) -> {
            if(a[col - 1] == b[col - 1]) return b[0] - a[0];
            return a[col - 1] - b[col - 1];
        });
        // row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환
        for (int i = row_begin; i <= row_end; i++){
            int s = 0;
            for(int d : data[i-1]){
                s += d % i;
            }
            
            answer ^= s;
        }
        return answer;
    }
}