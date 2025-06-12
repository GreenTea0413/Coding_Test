import java.util.Scanner;

public class Main {
    static int N;
    static int[] board;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N];  // board[i]는 i번째 행에서 퀸의 위치 (열 번호)
        count = 0;
        
        placeQueen(0);
        System.out.println(count);
    }

    public static void placeQueen(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col;
            if (isValid(row)) {
                placeQueen(row + 1);
            }
        }
    }

    public static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] ||  // 같은 열 검사
                Math.abs(board[row] - board[i]) == row - i) {  // 대각선 검사
                return false;
            }
        }
        return true;
    }
}
