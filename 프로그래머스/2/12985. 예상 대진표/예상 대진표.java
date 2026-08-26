class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        
        // 토너먼트 형식
        // 2로 나누기
        // 0 1 2 3 4 5 6 7
        // 0 0 1 1 2 2 3 3
        
        // 0 1 2 3
        // 0 0 1 1
        
        // 0 1
        // 0 0
        a = a - 1;
        b = b - 1;
        
        while(a != b){
            a = a / 2;
            b = b / 2;
            answer++;
        }
        
        return answer;
    }
}