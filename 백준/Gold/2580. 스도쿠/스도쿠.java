

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    
        StringTokenizer st;
        // 스도쿠 퍼즐 최초에 담기
        for(int i =0; i <9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }

    public static void sudoku(int x, int y){
        // 가로줄 먼저 비교하고 끝에 도착하면 내려가면서 비교
        if(y == 9){
            sudoku(x + 1, 0);
            return;
        }
        // 이제 가로 한줄한줄 가다가 내려가 보면 끝에 도달함
        if(x == 9){
            StringBuilder sb = new StringBuilder();
            for(int i =0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(map[i][j]).append(' ');
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        // 0일때 가로 세로 3 * 3 박스안에 중복되는 값이 있으면 안됨
        if(map[x][y] == 0){
            for(int i = 1; i <= 9; i++){
                if(isValid(x,y,i)){
                    map[x][y] = i;
                    sudoku(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }

        sudoku(x, y + 1);
    }

    public static boolean isValid(int x, int y, int value){
        //같은 열에 같은 숫자 이으면 아웃
		for(int i = 0 ; i < 9 ; i ++) {
			if(map[x][i] == value) {
				return false;
			}
		}
		
		//같은 행에 같은 숫자 있으면 아웃
		for(int i = 0 ; i < 9 ; i ++) {
			if(map[i][y] == value) {
				return false;
			}
		}

        // 이제 박스안에서 같은 값 있으면 아웃
        int box_x = (x / 3) * 3;
        int box_y = (y / 3) * 3;

        for(int i = box_x; i < box_x + 3; i++){
            for(int j = box_y; j<box_y + 3; j++){
                if(map[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }
}
