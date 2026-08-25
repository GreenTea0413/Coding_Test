class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            // 1부터 시작해서 쭈우우욱 더하기
            int count = i;
            int inc = i + 1;
            while(true){
                if(count == n) {answer ++; break;}
                else if(count > n) break;
                count += inc;
                inc++;
            }
        }
        
        return answer;
    }
}