class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        
        String[] arr = s.split(" ", -1);
        for(int i = 0; i < arr.length; i++){
            String t = arr[i];
            int len = t.length();
            
            if(len > 0) {
                answer.append(String.valueOf(t.charAt(0)).toUpperCase());
                answer.append(t.substring(1));
            }
            
            if(i < arr.length - 1) answer.append(" ");
        }
        
        return answer.toString();
    }
}