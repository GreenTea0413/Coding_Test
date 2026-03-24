class Solution {
    public int solution(String word) {
        // 5가지를 총 하는 방법은 3125
        // 1자리 1
        // 2자리 5
        // 3자리 25
        // 4자리 125
        // 5자리 625 라고 하네요
        
        int[] w = new int[] {781, 156, 31, 6, 1};
        String moum = "AEIOU";
        int answer = 0;
        for(int i = 0; i < word.length(); i++){
            int idx = moum.indexOf(word.charAt(i));
            answer += idx * w[i] + 1;
        }
        
        return answer;
    }
}