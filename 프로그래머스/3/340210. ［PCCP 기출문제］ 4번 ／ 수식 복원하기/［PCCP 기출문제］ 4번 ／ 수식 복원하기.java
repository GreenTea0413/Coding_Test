import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        // 10진수아님! (2 ~ 9진법 중 하나입니다.)
        // 이거 숫자만 빼내기 만약에 X가 있으면 거르기
        // 1 4 3 1 7 -> 7이있으니까 여기는 8 진수 아니면 9진수임!
        int maxDigit = 0;
        for(String exp : expressions){
            String[] s = exp.split(" ");
            
            for(int idx : new int[]{0, 2, 4}){
                if(s[idx].equals("X")) continue;
                for(char c : s[idx].toCharArray()){
                    maxDigit = Math.max(maxDigit, c - '0');
                }
            }
        }
        
        // 이제 진수 최소를 구했으니까 저게 7이니까 8 ~ 9까지
        // X가 없는 식들 가져와서 14 -> 7진수 일때랑 3 -> 7 진수 일 때 더한게 17의 7진수의 값이 맞으면?
        // 진수 가능한거 담기
        List<Integer> digits = new ArrayList<>(); 
        for(int i = maxDigit + 1; i < 10; i++){
            // 하나라도 그 진수가 안맞으면 바로 아웃!
            boolean check = true;
            for(String exp : expressions){
                String[] s = exp.split(" ");
                if(s[4].equals("X")) continue;
                
                if(calc(s, i) != Integer.parseInt(s[4], i)) {
                    check = false;
                    break;
                }
            }
            if(check) digits.add(i);
        }
        
        // 진수 다 구했으면 이제 X 찾으러 가야함
        
        List<String> answer = new ArrayList<>();
        
        for(String exp : expressions){
            String[] s = exp.split(" ");
            if(!s[4].equals("X")) continue;
            
            // 여기서 진수 구한걸로 calc하기 -> 그 구한걸 다시 진수로 나누기
            // 근데 만약에 X의 값이 여러개다? 그러면 ? 1개라면 1개 그대로 내보내기
            Set<String> set = new HashSet<>();
            for(int d : digits) set.add(Integer.toString(calc(s, d), d));
            
            StringBuilder sb = new StringBuilder();
            sb.append(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " ");
            if(set.size() > 1) sb.append("?");
            else sb.append(set.iterator().next());
            
            answer.add(sb.toString());
        }
        
        return answer.toArray(new String[0]);
    }
    
    int calc(String[] s, int digit){
        return s[1].equals("+") 
            ? Integer.parseInt(s[0], digit) + Integer.parseInt(s[2], digit) 
            : Integer.parseInt(s[0], digit) - Integer.parseInt(s[2], digit);
    }
}