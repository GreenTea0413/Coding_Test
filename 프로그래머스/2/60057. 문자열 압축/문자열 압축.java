import java.util.*;

class Solution {
    public int solution(String s) {
        int result = s.length();  // 초기값: 압축을 안 했을 경우 (최악의 경우)

        // 압축 단위를 1부터 문자열 길이의 절반까지 시도
        for (int l = 1; l <= s.length() / 2; l++) {
            result = Math.min(result, compress(s, l));  // 압축 결과 중 가장 짧은 길이로 갱신
        }

        return result;
    }

    // 문자열을 주어진 단위 길이로 압축하는 메서드
    int compress(String text, int length) {
        List<String> words = new ArrayList<>();

        // 주어진 압축 단위만큼 잘라서 리스트에 저장
        for (int i = 0; i < text.length(); i += length) {
            // 끝부분이 단위보다 작을 수도 있으므로 substring 범위 조정
            words.add(text.substring(i, Math.min(text.length(), i + length)));
        }

        StringBuilder compressed = new StringBuilder();
        String prevWord = "";  // 이전에 비교했던 단어
        int count = 0;         // 반복 횟수 카운트

        for (String word : words) {
            if (word.equals(prevWord)) {
                count++;  // 동일 단어 반복 중
            } else {
                if (count > 1) {
                    compressed.append(count);  // 반복된 횟수 추가 (1회는 생략)
                }
                compressed.append(prevWord);  // 이전 단어 추가

                prevWord = word;  // 현재 단어를 이전 단어로 갱신
                count = 1;        // 새 단어로 시작 count 초기화
            }
        }

        // 마지막 남은 단어 처리
        if (count > 1) {
            compressed.append(count);
        }
        compressed.append(prevWord);

        return compressed.toString().length();  // 압축된 문자열의 길이 반환
    }
}
