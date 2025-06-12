
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] train = new int[N + 1][21];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(train[b][c] == 0){
                    train[b][c] = c;
                }
            }
            if(a == 2){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(train[b][c] != 0){
                    train[b][c] = 0;
                }
            }
            if(a == 3){
                int b = Integer.parseInt(st.nextToken());
                for(int j = 20; j >= 2; j--){
                    train[b][j] = train[b][j - 1];
                }
                train[b][1] = 0;
            } 
            if(a == 4){
                int b = Integer.parseInt(st.nextToken());
                for(int j = 1; j <= 19; j++){
                    train[b][j] = train[b][j + 1];
                }
                train[b][20] = 0;
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                if(train[i][j] != 0) sb.append(1);
                else sb.append(0);
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());
    }
}
