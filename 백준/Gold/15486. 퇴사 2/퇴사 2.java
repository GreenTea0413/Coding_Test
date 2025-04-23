import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine().trim());
        int[] day = new int[test_case + 1];
        int[] money = new int[test_case + 1];
        
        // 1부터 n까지 상담 정보 입력받기
        for (int i = 1; i <= test_case; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 생성
        int[] dp = new int[test_case + 2];  // 상담을 끝낸 후 남은 날 수까지 포함

        // DP를 역순으로 채워나가기
        for (int i = test_case; i >= 1; i--) {
            int nextDay = i + day[i];  // 상담이 끝나는 날
            if (nextDay <= test_case + 1) {
                dp[i] = Math.max(money[i] + dp[nextDay], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];  // 상담을 할 수 없다면, 이전의 최대 수익을 그대로 가져옴
            }
        }

        System.out.println(dp[1]);
        br.close();
    }
}
