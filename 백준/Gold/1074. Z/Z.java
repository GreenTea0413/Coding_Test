

import java.io.*;
import java.util.*;

public class Main {
    // N이 1일 때, 
    // 0,0 0,1 1,0 1,1
    
    // 사분면으로 나눠서 풀어볼 것
    // 정사각형으로 가니까 일단 N 값이 1,2,3 -> 2x2, 4x4, 8x8
    // 그럼 가로 세로 하나당 2, 4, 8 임 이걸로 2로 나누면 가로 세로 딱 중간이기 때문에
    // 어느 사분면에 내 r,c가 포함하는지 알 수 있음
    // 그러면 나눈 그 사분면 안에서 계속 r, c가 포함되면 + 1하고 계속 재귀
    static int N; static int R; static int C;
    static int count = 0;
    public static void countZ(int n, int r, int c){
        if(n == 1){
            System.out.println(count);
            return;
        }
        int half = n / 2;
        // 이러면 크기가 지금 N이 1이라고 생각했을 때 n은 2가 되기에
        // 4 / 4 = 1이 된다 이렇게 사분면을 기준으로 해서 하면 될거 같음
        // count = (n * n) / 4; -> 1사분면 0 2사분면은 1 3사분면은 * 3 4사분면은 * 2
        // R, C가 지금 일단 사분면 어디에 들어가는지를 봐야하니까 기준을 half로 나눴으니 좌우 상하
        // 크기가 2 x 2면 half = 1 이니까 
        // 1,1 1사분면에 가야함 근데 half >= 로 둘 다 비교하는 순간 이상한 곳으로 감


        // 1사분면
    if (r < half && c < half) {
        countZ(half, r, c);
    }
    // 2사분면
    else if (r < half && c >= half) {
        count += half * half;
        countZ(half, r, c - half);
    }
    // 3사분면
    else if (r >= half && c < half) {
        count += half * half * 2;
        countZ(half, r - half, c);
    }
    // 4사분면
    else {
        count += half * half * 3;
        countZ(half, r - half, c - half);
    }
    }
    public static void main(String[] args) throws IOException{
        ///첫째 줄에 정수 N, r, c가 주어진다.
        //r행 c열을 몇 번째로 방문했는지 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        countZ((int)Math.pow(2,N), R, C);
    }
}
