import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {        
        // data의 첫 컬럼이 기본키
        // 1 5 10 -> 1가 기본키
        
        // col이 2라면 배열에서는 [1]자리 숫자들 정렬
        // 2 2 6
        // 1 5 10
        // 4 2 9
        // 3 8 3
        // 근데 4 2 9 랑 2 2 6이 2가 같기 때문에 [0]번째 기본키를 내림차순으로 정렬
        // 4 2 9 
        // 2 2 6
        // 1 5 10
        // 3 8 3
        Arrays.sort(data, (a, b) -> {
            if(a[col - 1] == b[col - 1]) return b[0] - a[0];
            return a[col - 1] - b[col -1];
        });        
        // 그리고 그 범위는 row_beigin과 row_end 사이에 i를 두어 2 <= i <= 3
        // 그다음 각 취이마다 mod 나누고 합을 구하기 여기서 2 2 6이 2번째니까
        // 2 % 2, 2 % 2, 6 % 2래서 나머지 값 더하기
        // 그리고 그 값들을 모아놓고 XOR 다해야함
        List<Integer> list = new ArrayList<>();
        for(int i = row_begin; i <= row_end; i++){
            int[] arr = data[i - 1];
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
                sum += arr[j] % i;
            }
            list.add(sum);
        }
        int answer = list.get(0);
        for(int i = 1; i < list.size(); i++){
            answer = answer ^ list.get(i);
        }
        
        return answer;
    }
}