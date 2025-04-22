import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        //6
        //10 30 10 20 20 10   
        int test_case = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int answer = 1;
        int [] arr = new int[test_case + 1];
        int [] dp = new int[test_case + 1];
         // 여기까지 배열 만들고, dp도 만들었음
        // 이제 구현 해야하는데 
        // dp는 현재 다 0
        // arr i 부터해서 i + 1부터 하는 이중 for문으로 비교 했을 때 
        for(int i = 1; i <= test_case; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            // i가 1일 때 ->  
            for(int j = i; j >= 1; j--){
                // 내 위치에서 부터 아래로 큰 값이 있는지 비교
                // j가 점점 재려가는 거니까 만약에 지금 
                // 1 4 2 3
                // i가 2여서 4를 가리키고 있을 떄 
                // j는 4 -> 1
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    answer = Math.max(dp[i],answer);
                }
            }
        }   
        System.out.println(answer);

    }
}
