class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 1 2 3 4 5 6 7 8
        a --;
        b --;
        while(a != b){
            a /= 2;
            b /= 2;
            
            answer++;
        }

        return answer;
    }
}