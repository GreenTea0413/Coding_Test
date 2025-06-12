import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] A;
    static int totalPeople = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        // 여기에 이제 인구수 담는거임
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += A[i][j];
            }
        }

        // 모든 가능한 (x, y, d1, d2) 완전 탐색
        // 범위는 주어진거 그대로 사용하면 됨
        // d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N
        // 조건 보면 x,y,d1,d2 다 1이상 시작하면 됨 ㅇㅇ
        // x+d1+d2 는 일단 N 보다 크면 안됨
        // y도 y + d2도 N보다 크면 안됨
        // y-d1 한 것도 1보다 커야함
        // 이제 다 거르고 걸러서 Dfs 하면 됨
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        dfs(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(min);
    }

    static void dfs(int x, int y, int d1, int d2) {
        // 이걸로 이제 1,2,3,4,5 위치 나눠서
        // 값 넣은 다음에 채우기 할거임
        boolean[][] border = new boolean[N][N];

        // 경계선 세팅
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        // 나머지 구역 1~4번 범위 안에 들어가는 거 채우기
        // 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y, 1번 경계선의 왼쪽 위
        // 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N, 2번 경계선의 오른쪽 위
        // 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2, 3번 경계선의 왼쪽 아래
        // 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N, 4번 경계선의 오른쪽 아래
        // r이랑 c랑 위에 조건 준거 맞춰서 1 이상 처리했고 나머지 조건 맞으면 채워주기
        int[] peopleSum = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                peopleSum[0] += A[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j]) break;
                peopleSum[1] += A[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                peopleSum[2] += A[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                peopleSum[3] += A[i][j];
            }
        }

        // 5 구역 인구수
        peopleSum[4] = totalPeople;
        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        // 정렬
        Arrays.sort(peopleSum);

        // 최대 - 최소
        min = Math.min(min, peopleSum[4] - peopleSum[0]);
    }
}
