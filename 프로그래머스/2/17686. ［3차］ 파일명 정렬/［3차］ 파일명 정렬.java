import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, (a, b) -> {
            // 1. HEAD 분리
            String headA = getHead(a);
            String headB = getHead(b);

            int headCompare = headA.toLowerCase().compareTo(headB.toLowerCase());
            if(headCompare != 0) return headCompare;

            // 2. NUMBER 비교
            int numA = getNumber(a);
            int numB = getNumber(b);

            return numA - numB;
        });

        return files;
    }

    // HEAD 추출
    private String getHead(String s){
        int i = 0;
        while(i < s.length() && !Character.isDigit(s.charAt(i))){
            i++;
        }
        return s.substring(0, i);
    }

    // NUMBER 추출
    private int getNumber(String s){
        int i = 0;

        // 숫자 시작 위치 찾기
        while(i < s.length() && !Character.isDigit(s.charAt(i))){
            i++;
        }

        int start = i;

        // 숫자 최대 5자리
        while(i < s.length() && Character.isDigit(s.charAt(i)) && i - start < 5){
            i++;
        }

        return Integer.parseInt(s.substring(start, i));
    }
}