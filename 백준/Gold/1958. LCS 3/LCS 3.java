
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int lenA = A.length();
        int lenB = B.length();
        int lenC = C.length();

        int[][][] dp = new int[lenA+1][lenB+1][lenC+1];

        for(int i =1; i <= lenA; i++){
            for(int j= 1; j <= lenB; j++){
                for(int k = 1; k <= lenC; k++){
                    // 3번 다 돌면서 이제 값 같으면 횟수 같은거니까 +1 해주기
                    if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        // 아니면 이제 각 문자열에서 앞에꺼 구했던 값 가져와서 비교 후 최댓값
                        dp[i][j][k] = Math.max(
                            Math.max(dp[i - 1][j][k], dp[i][j - 1][k]),
                            dp[i][j][k - 1]
                        );
                    }
                }
            }
        }
        System.out.println(dp[lenA][lenB][lenC]);
    }
}
