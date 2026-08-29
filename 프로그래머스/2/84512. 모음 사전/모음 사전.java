class Solution {
    public int solution(String word) {
        int answer = 0;
        // 5 * 5 * 5 * 5 * 5
        // 1 5 25 125 625
        int[] alpabet = {781,156,31,6,1};
        String moum = "AEIOU";
        
        for(int i = 0; i < word.length(); i++){
            int idx = moum.indexOf(word.charAt(i));
            answer += alpabet[i] * idx + 1;
        }
        
        return answer;
    }
}