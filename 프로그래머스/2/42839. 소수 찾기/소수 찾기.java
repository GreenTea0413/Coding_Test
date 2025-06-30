import java.util.*;
class Solution {
    static Set<Integer> numberSet = new HashSet<>();
    static boolean[] visited;

    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];

        // 이걸로 모든 경우 다 만들기
        dfs("", numbers); 

        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    // DFS를 이용한 순열 생성
    // 이렇게 하면 중복이여도 그냥 set에서 거르기때문에 다 저장하게 하면 됌
    private static void dfs(String current, String numbers) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current)); 
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                // 걍 다 더하도록 해서 반복 하는 거임
                dfs(current + numbers.charAt(i), numbers); 
                visited[i] = false; 
            }
        }
    }

    // 소수 판별 함수
    private static boolean isPrime(int n) {
        if (n < 2) return false;

        // 이거 소수 저번에 했던건데 범위를 제곱으로 나눠야 초과 안뜸
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}