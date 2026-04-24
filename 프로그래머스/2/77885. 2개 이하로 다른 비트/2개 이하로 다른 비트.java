class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];

        for(int i = 0 ; i < len; i++){
            long num = numbers[i];
            
            if(num % 2 == 0){
                answer[i] = num + 1;
            }
            else{
                String n = "";
                while(num > 0){
                    long rest = num % 2;
                    n = rest + n;
                    num /= 2;
                }
                n = "0" + n;
                
                int idx = n.lastIndexOf("01");
                
                String result = n.substring(0, idx) + "10" + n.substring(idx + 2);
                answer[i] = Long.parseLong(result, 2);
            }
        }
        
        return answer;
    }
}