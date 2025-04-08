
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        // 여기가 5
        int n =  Integer.parseInt(br.readLine());
        // 배열 만들고나서
        int[] arr = new int[n];

        // 한줄 4 1 5 2 3
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 여기서 배열에 넣은 값 정렬 그래야 이진 탐색 편함
        Arrays.sort(arr);

        // 여기가 이제 위에서 만든 arr안에 숫자 있냐 없냐를 찾는 배열
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int j = 0; j < m; j++) {
            int check = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(arr, check) >= 0) {
                sb.append(1 ).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

