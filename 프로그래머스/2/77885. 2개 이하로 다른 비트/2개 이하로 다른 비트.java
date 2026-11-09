class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for(int i = 0; i < len; i++){
            long n = numbers[i];
            if(n % 2 == 0) answer[i] = n + 1;
            // 홀수면 이게 01을 찾아서 10으로 바꿔줘야함 -> 바로
            else{
                String bin = Long.toString(n, 2); bin = "0" + bin;
                int idx = bin.lastIndexOf("01");
                
                StringBuilder sb = new StringBuilder();
                sb.append(bin.substring(0, idx));
                sb.append("10");
                sb.append(bin.substring(idx + 2));
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        return answer;
    }
}