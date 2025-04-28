
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void hanoi(int n, char from, char aux, char to){
        //n-1개의 원판을 출발지 → 보조기둥(aux) 으로 옮긴다.
        //가장 큰 원판 1개를 출발지 → 목적지(to) 로 옮긴다.
        //n-1개의 원판을 보조기둥(aux) → 목적지(to) 로 옮긴다.
        if (n == 1) {
            sb.append(from + " " + to).append('\n');
            count ++;
            return;
        }
        hanoi(n - 1, from, to, aux);  
        sb.append(from + " " + to).append('\n');
        count ++;
        hanoi(n - 1, aux, from, to);  
    }
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine().trim());

        hanoi(n, '1', '2', '3');
        System.out.println(count);
        System.out.print(sb);
    }
}
