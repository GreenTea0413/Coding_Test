import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // int[] → String[]
        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strs[i] = String.valueOf(numbers[i]);
        }

        // 핵심: a+b vs b+a 비교로 정렬
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 전부 0인 경우 예외처리 ex) [0, 0, 0]
        if(strs[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : strs) sb.append(s);

        return sb.toString();
    }
}