import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        // 2 162
        int count = 1;
        while (B > A) {
            //162를 2로 만드는 방법의 최솟값
    
            // 162 -> 81 -> 8 -> 4 -> 2 이렇게 되도록 하면 됨
            // 일단 먼저 2로 나누는 방식을 한 다음에 2로 안나눠지는거면 뒤에 1을 없애면 됨
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            count++;
        }

        if (B == A) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
