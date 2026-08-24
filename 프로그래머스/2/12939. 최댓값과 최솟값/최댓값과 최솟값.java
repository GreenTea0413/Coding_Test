class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int max = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String a : arr){
            max = Math.max(Integer.parseInt(a), max);
            min = Math.min(Integer.parseInt(a), min);
        }
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}