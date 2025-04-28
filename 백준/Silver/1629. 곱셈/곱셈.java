
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        // 이러면 값이 말도 안되게 커짐
        //System.out.print((int)(Math.pow(A,B) % C));

        // 그래서 찾아보니 지수를 반틈으로 나눠서 분할로 계산하게끔!
        System.out.println(remainder(A,B,C));
    }

    public static long remainder(long a, long b, long c){
        // 지수가 1 이면 바로 나머지 반환
        // b 11 -> 5 -> 2 -> 1
        if(b == 1){
            return a % c;
        }
        // 지수가 1 이상이면 지수를 반으로 나누어 다시 나머지 구하기
        // 처음 newSize는 b 가 1일 때까지 내려가서 하니까 10 % 12
        // 그 다음 반환해서 오면 10을 가지고 b는 2이니까 바로 newSize * newSize % c
        // ...이런식으로 분할 해서 점차 올라오면 값을 구할 수 있다!
        else{
            long newSize = remainder(a, b / 2, c);
            if(b % 2 == 1){
                return (newSize * newSize % c) * a % c;
            }
            return newSize * newSize % c;
        }
    }
}
