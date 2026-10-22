class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(true){
            if(s.equals("1")) break;
            
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') count++;
            }
            answer[0] ++;
            answer[1] += count;
            
            int num = s.length() - count;
            String temp = "";
            
            while(num > 0){
                int rest = num % 2;
                temp = String.valueOf(rest) + temp;
                num = num / 2;
            }
            s = temp;
        }
        
        return answer;
    }
}