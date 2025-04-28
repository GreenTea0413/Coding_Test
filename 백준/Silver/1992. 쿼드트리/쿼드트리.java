import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static String answer = "";
    public static void QuadTree(int col, int row, int size){
        int start = arr[col][row];
        boolean isSame = true;
        for(int i = col; i < col + size; i++){
            for(int j = row; j < row + size; j++){
                if(start != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }
        if(isSame){
            if(start == 1) answer += '1';
            if(start == 0) answer += '0';
            return;
        }
        else{
            int newSize = size / 2;
            answer += '(';
            for(int k = 0; k < 2; k ++){
                for (int l = 0; l < 2; l ++){
                    QuadTree(col + k * newSize, row + l * newSize, newSize);
                }
            }
            answer += ')';
        }
    }
    public static void main(String[] args) throws IOException{
        // (0(0011)(0(0111)01)1)
        // 어우 문제 진짜 더러워
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        QuadTree(0, 0, N);
        System.out.println(answer);
    }
}
