import java.io.*;
import java.util.*;

public class Main {
    static int N, S, answer;
    static int[] arr;

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }

        // 현재 원소 포함
        dfs(depth + 1, sum + arr[depth]);

        // 현재 원소 미포함
        dfs(depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        answer = 0;
        dfs(0, 0);

        // 공집합 제외시키는 경우
        if (S == 0) answer--;

        System.out.println(answer);
    }
}
