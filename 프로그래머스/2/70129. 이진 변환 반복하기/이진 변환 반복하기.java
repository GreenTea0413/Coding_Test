class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            answer[0] += 1;
            int len = 0;
            
            for(int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '0') answer[1] += 1;
                else len += 1;
            }
            
            s = toStr(len);
        }
        return answer;
    }
    
    public String toStr(int n){
        String temp = "";
        
        while (n > 0){
            int r = n % 2;
            temp += String.valueOf(r);
            n /= 2;
        }
        
        return temp;
    }
}