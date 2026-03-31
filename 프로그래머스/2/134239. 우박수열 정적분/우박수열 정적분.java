import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        // (0, 5), (1, 16), (2, 8), (3, 4), (4, 2), (5, 1)
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k > 1){
            if (k % 2 == 0) { k /= 2;}
            else {k = k * 3 + 1;}
            list.add(k);
        }
        
        // 미리 모든 한칸한칸 구간의 넓이를 구하기
        // 0 ~ 1, 1 ~ 2, 2 ~ 3, 3 ~ 4, 4 ~ 5
        int n = list.size() - 1;
        double[] sqr = new double[n];
        for(int i = 0; i < n; i++){
            sqr[i] = (list.get(i)+ list.get(i + 1)) / 2.0;
        }
        
        // 그 다음 범위에 대한 넓이 구하기
        // 1 -> 0 ~ 1 2 -> 0 ~ 2...
        double[] total_sqr = new double[n + 1];
        for(int i = 0; i < n; i++){
            total_sqr[i + 1] = total_sqr[i] + sqr[i];
        }
        
        // x = a, x = n - b, y = 0
        double[] answer = new double[ranges.length];
        for(int i = 0; i < ranges.length; i++){
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if(a > b) answer[i] = -1;
            else {answer[i] = total_sqr[b] - total_sqr[a];}
        }
        
        return answer;
    }
}