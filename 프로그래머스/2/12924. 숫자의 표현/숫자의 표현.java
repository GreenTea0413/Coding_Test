class Solution {
    public int solution(int n) {        
        // 본인 포함하기때문에 무조건 하나 있음
        int answer = 1;
        
        // 본인 중간 이상보다 넘어서 시작하면 절대 안됨
        for(int i = 1; i <= n / 2; i++){
            int sum = i;
            for(int j = i + 1; j <= n / 2 + 1; j++){
                sum += j;
                if (sum > n) break;
                else if(sum == n) {answer++; break;}
            }
        }
        return answer;
    }
}