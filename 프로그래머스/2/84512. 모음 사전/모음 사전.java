class Solution {
    public int solution(String word) {
        // 1 5 25 125 625
        int[] count = new int[] {781, 156, 31, 6, 1};
        String moum = "AEIOU";
        int answer = 0;
        for(int i = 0; i < word.length(); i++){
            int idx = moum.indexOf(word.charAt(i));
            answer += count[i] * idx + 1;
        }
        
        return answer;
    }
}