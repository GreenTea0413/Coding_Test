import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt(); // test 케이스 몇개 들어 갈지

        int [] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int j = 4; j < 11; j++){
            // 규칙을 잘 따라가보면 처음에 1 다음 2개 4개 이렇게 보임!
            // 1 -> 1
            // 2 -> 1 + 1, 2
            // 3 -> 1 + 1 + 1, 2 + 1, 1 + 2, 3
            // 그래서 일단 더 해보기
            dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
        }

        for (int i = 0; i < test_case; i++){
            int print_num = sc.nextInt();
            System.out.println(dp[print_num]);
        }

    }
}