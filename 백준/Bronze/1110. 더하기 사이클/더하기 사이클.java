import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 초기값 N 입력
        int original = N;     // 원래 숫자를 저장
        int cycleLength = 0;  // 사이클 길이 계산
        
        do {
            int leftDigit = N / 10;    // N의 십의 자리 수
            int rightDigit = N % 10;   // N의 일의 자리 수
            int sum = leftDigit + rightDigit;  // 자리 수의 합
            N = rightDigit * 10 + sum % 10;    // 새로운 수 생성
            
            cycleLength++;  // 사이클 길이 증가
        } while (N != original);  // 처음 숫자로 돌아올 때까지 반복
        
        System.out.println(cycleLength);  // 사이클 길이 출력
        sc.close();
    }
}
