class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        // 앞뒤 무조건 안되는 경우 제외
        if(s.charAt(0) == ')'){
            answer = false;
            return answer;
        }
        else if(s.charAt(s.length() -1) == '('){
            answer = false;
            return answer;
        }
        // 그리고 다시 시작
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count ++;
            }
            else{
                count --;
            }
            if(count < 0){
                return false;
            }
        }
        
        if(count != 0){
            answer = false;
        }
        return answer;
    }
}