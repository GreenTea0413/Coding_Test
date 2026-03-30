import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // 열은 컬럼, 행은 튜플
        // col번째 기준으로 오름차순
        // 값 같으면 col번째 값이 같다면 data[i][0] 값을 기준으로 내림차순
        // 이게 무슨 소리일까..
        // 정렬 다 된거에다가 꺼내서 i 번째 튜플의 date[i] 값들을 i로 나눈 나머지로 합을 정의
        // i의 범위는 row_begin과 row_end 사이
        // 그리고 그게 bitwise XOR -> ^ 한 값을 해시 값으로서 반환
        
        Arrays.sort(data, (a, b) -> {
            if (b[col - 1] == a[col - 1]) return b[0] - a[0];
            return a[col - 1] - b[col - 1];
        });
        

        for(int i = row_begin; i <= row_end; i++){
            int sum = 0;
            for (int d : data[i - 1]){
                sum += d % i;
            }
            answer ^= sum;
        }
        
        return answer;
    }
}