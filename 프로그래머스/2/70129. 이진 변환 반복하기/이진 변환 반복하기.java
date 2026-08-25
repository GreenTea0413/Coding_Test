class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        // answer[0] 은 0 제거하고 난 문자열 길이를 2진수로 바꾼 횟수
        // answer[1] 은 0 제거된 횟수
        while(true){
            if(s.equals("1")) break;
            int count = 0;
            
            for(char c : s.toCharArray()){
                if(c == '0') answer[1]++;
                if(c == '1') count++;
            }
            
            // 0을 제외한 1의 나머지 길이만큼 2진으로 다시 나타내야함
            // 길이가 4
            String next = "";
            while(count > 0){
                int rest = count % 2;
                next = String.valueOf(rest) + next;
                count = count / 2;
            }
            s = next;
            answer[0] ++;
        }
        return answer;
    }
}