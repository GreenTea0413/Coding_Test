public class Solution {
    public String solution(String new_id) {
        // 1단계: 모든 대문자를 소문자로 치환
        String answer = new_id.toLowerCase();
        
        // 2단계: 알파벳 소문자, 숫자, '-', '_', '.'만 남기고 모두 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계: '.'가 2번 이상 연속된 부분 하나로 치환
        answer = answer.replaceAll("[.]{2,}", ".");
        
        // 4단계: 처음이나 끝에 '.'가 있으면 제거
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        // 5단계: 빈 문자열이면 "a" 대입
        if (answer.isEmpty()) {
            answer = "a";
        }
        
        // 6단계: 길이가 16자 이상이면 첫 15자만 남기고 나머지 제거
        //       만약 제거 후 마지막 문자가 '.'면 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$", "");
        }
        
        // 7단계: 길이가 2자 이하이면 마지막 문자 반복해서 3자 만들기
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}
