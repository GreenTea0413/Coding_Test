class Solution {
    public int solution(String word) {
        int answer = 0;
        String moum = "AEIOU";
        // 625 125 25 5 1
        int[] count = {781, 156, 31, 6, 1};
        
        for(int i = 0; i < word.length(); i++){
            int idx = moum.indexOf(word.charAt(i));
            answer += count[i] * idx + 1;
        }
        return answer;
    }
}