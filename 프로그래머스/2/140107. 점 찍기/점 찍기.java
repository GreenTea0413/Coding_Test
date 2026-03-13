class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(long i = 0; i <= d; i += k){
            // y 루프 대신 바로 계산
            long maxY = (long)d * d - i * i;
            long sqrtY = (long) Math.sqrt(maxY);
            // 오차 보정
            while((sqrtY + 1) * (sqrtY + 1) <= maxY) sqrtY++;
            while(sqrtY * sqrtY > maxY) sqrtY--;
            answer += sqrtY / k + 1;
        }
        return answer;
    }
}
