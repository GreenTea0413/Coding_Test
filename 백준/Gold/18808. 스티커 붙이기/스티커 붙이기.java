import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static List<int[][]>[] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노트북 행
        M = Integer.parseInt(st.nextToken()); // 노트북 열
        K = Integer.parseInt(st.nextToken()); // 스티커 개수

        map = new int[N][M];
        stickers = new ArrayList[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[a][b];

            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < b; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전된 4가지 모양을 리스트에 저장
            stickers[i] = new ArrayList<>();
            for (int r = 0; r < 4; r++) {
                stickers[i].add(sticker);
                sticker = rotate90(sticker);
            }
        }

        // 스티커 하나씩 붙이기 시도
        for (int i = 0; i < K; i++) {
            boolean attached = false;
            for (int[][] sticker : stickers[i]) {
                int R = sticker.length;
                int C = sticker[0].length;

                for (int x = 0; x <= N - R; x++) {
                    for (int y = 0; y <= M - C; y++) {
                        if (canAttach(sticker, x, y)) {
                            attach(sticker, x, y);
                            attached = true;
                            break;
                        }
                    }
                    if (attached) break;
                }
                if (attached) break;
            }
        }

        // 결과 출력: 1의 개수
        int result = 0;
        for (int[] row : map) {
            for (int val : row) {
                if (val == 1) result++;
            }
        }
        System.out.println(result);
    }

    // 회전: 시계방향 90도
    static int[][] rotate90(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;
        int[][] rotated = new int[C][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rotated[j][R - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    // 현재 위치에 붙일 수 있는지 확인
    static boolean canAttach(int[][] sticker, int x, int y) {
        int R = sticker.length;
        int C = sticker[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1 && map[x + i][y + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // 실제로 붙이기
    static void attach(int[][] sticker, int x, int y) {
        int R = sticker.length;
        int C = sticker[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1) {
                    map[x + i][y + j] = 1;
                }
            }
        }
    }
}