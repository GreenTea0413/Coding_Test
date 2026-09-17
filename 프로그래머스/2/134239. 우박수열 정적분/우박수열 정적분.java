import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int n = 0;
        int len = ranges.length;
        double[] answer = new double[len];
        
        List<int[]> dots = new ArrayList<>();
        
        while(k > 1){
            dots.add(new int[]{n, k});
            n++;
            
            if(k % 2 == 0) k =  k / 2;
            else k = 3 * k + 1;
        }
        dots.add(new int[]{n, 1});
        
        // x에 대한 어떤 범위 [a, -b]
        // ranges -> [0,0] -> [0, 0] ~ [0, n - 0]까지의 넓이
        // 매번 계산하기 어려우니 미리 구하기
        // 0,0 ~ 해당 좌표들까지의 너비 구하기 가로 한칸씩 늘려가면서 하기
        // 0,5 0,0 1,0 1,16 / 1,0 1,16 2,0 2,5
        double[] space = new double[n + 1];
        for(int i = 1; i <= n; i++){
            double y = dots.get(i - 1)[1];
            double ny = dots.get(i)[1];
            
            space[i] = (ny + y) / 2;
        }
        
        // 그 다음 이제 범위 내에서 값 구하기
        for(int i = 0; i < len; i++){
            double sum = 0;
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if(a > b) answer[i] = -1;
            else{
                for(int j = a + 1; j <= b; j++) sum += space[j];
                answer[i] = sum;
            }
        }
        return answer;
    }
}