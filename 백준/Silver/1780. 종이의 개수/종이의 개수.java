

import java.io.*;
import java.util.*;

public class Main {
    static int paper_ = 0;  //-1인 종이
    static int paper_0 = 0; // 0인 종이
    static int paper_1 = 0; // 1인 종이
    static int[][] paper;   // 종이 배열

    public static void paperCount(int row, int col, int size){
        boolean isSame = true;
        int num = paper[row][col];
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(num != paper[i][j]){
                    isSame= false;
                    break;
                }
            }
            if (!isSame) break;
        }
        if(isSame){
            if(num == -1) paper_ += 1; 
            if(num == 0) paper_0 += 1;
            if(num == 1) paper_1 += 1;
            return;
       }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                paperCount(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        paper = new int[N][N]; // 종이 배열

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 일단 전체 통으로 들어가
        //paper 자체를 가져감   시작점 0,0 크기 N으로 하면 되겠다
        // 그리고 0 ~ N까지 이중 For문 바로 돌리기
        // 그랬는데 다르다? 그럼 바로
        // 다음 재귀 [0, (N / 3)] , [(N / 3) , (N / 3) * 2] ,(N / 3) * 2 [ (N / 3) * 3]
        // 이렇게 되는거지~      
        paperCount(0, 0, N);
        System.out.println(paper_);
        System.out.println(paper_0);
        System.out.println(paper_1);
        br.close();
    }
    
}
