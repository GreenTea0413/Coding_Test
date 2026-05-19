import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        dfs(0);
    }

    public static void dfs(int depth){
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < m; i++){
                sb.append(arr[i]);
                if(i < m - 1){
                    sb.append(" ");
                }
            }
            System.out.println(sb);
            return;
        }

        for(int i = 1 ; i <= n; i++){
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}