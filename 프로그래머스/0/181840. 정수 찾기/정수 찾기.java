class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        
        for(int a : num_list){
            if(n == a){
                answer = 1;
            }
        }
        return answer;
    }
}