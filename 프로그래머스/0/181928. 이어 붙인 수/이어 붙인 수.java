class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int a = 0;
        int b = 0;
        
        for(int n : num_list){
            if(n % 2 == 0){
                b += n;
                b *= 10;
            }
            else {
                a += n;
                a *= 10;
            }
        }
        
        answer = a / 10 + b / 10;
        return answer;
    }
}