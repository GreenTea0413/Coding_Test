import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();

        int [] dp = new int[test_case + 1];
        int [] stair = new int[test_case + 1];

        for (int i = 1; i < test_case + 1; i++){
            stair[i] = sc.nextInt();
        }
        // 최대값 구하기니까
        // 1은 차피 무조건 밟아야 하니까 1 넣고
        // 2도 최대가 1 + 2 해야하니까 더해야하고
        // 3은 대신에 1,2,3연속으로 못밟으니까 1->3 또는 2->3
        dp[1] = stair[1];
        if(test_case >= 2) dp[2] = stair[1] + stair[2];
        if(test_case >= 3) dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
        // 4면 1,3,4 / 2,4 
        // 그렇게 타고타고 올라가면 되니까
        
        for (int i = 4; i < test_case + 1; i++){
            dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
        }
        // 이제 여기서 부터 계속 값 최대값 비교함녀서 넣기
        System.out.println(dp[test_case]);
    }
}
