

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] paper;
    public static void paperCount(int col, int row, int size){
        int start = paper[col][row];
        boolean isSame = true;
        for(int i = col; i < col + size; i++){
            for(int j = row; j < row + size; j++){
                if(start != paper[i][j]){
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }
        if(isSame){
            // 여기서 범위 안의 직사각형이면 바로 +1 하고 빠지기
            if(start == 0) white += 1;
            if(start == 1) blue += 1; 
            return;
        }
        // 아니면 여기서 4등분 해서 진행 하도록 하기
        int newSize = size / 2;
        for(int k = 0; k < 2; k++){
            for(int l = 0; l < 2; l++){
                //좌표 이렇게 하면 0,0 0,4 / 4,0 4,4 돌게 하는 거임
                paperCount(col + l * newSize, row + k * newSize, newSize);
            }
        }  
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // N * N 정사각형
        // 여기서 
        int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        paper = new int[N][N];

        // 여기까지 이제 정사각형에 숫자 넣기 끝
        for(int i  = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());        
            }
        }

        // 이제 여기서 재귀를 시작해서 쪼개야함
        paperCount(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }
}
