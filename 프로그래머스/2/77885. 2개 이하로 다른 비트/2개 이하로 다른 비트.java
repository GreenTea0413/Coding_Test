class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for(int i = 0; i < len; i++){
            String st = "";
            long n = numbers[i];
            
            if(n % 2 == 0) answer[i] = n + 1;
            else{
                while(n > 0){
                    long rest = n % 2;
                    st = String.valueOf(rest) + st;
                    n /= 2;
                }

                st = "0" + st;

                int idx = st.lastIndexOf("01");
                String temp = st.substring(0, idx) + "10" + st.substring(idx + 2);
                answer[i] = Long.parseLong(temp, 2);
            }
        }
        
        
        
        return answer;
    }
}