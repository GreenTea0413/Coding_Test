import java.util.*;
import java.io.*;

public class Main {
    // 파이어볼 정보를 저장하는 클래스
    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r; // 행 위치
            this.c = c; // 열 위치
            this.m = m; // 질량
            this.s = s; // 속력
            this.d = d; // 방향
        }
    }

    static int N, M, K;
    static List<Fireball>[][] map; // 각 위치에 존재하는 파이어볼 리스트
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 8방향의 행 이동
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; // 8방향의 열 이동
    static List<Fireball> fireballs = new ArrayList<>(); // 전체 파이어볼 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기: 격자 크기 N, 파이어볼 개수 M, 명령 횟수 K
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자 크기
        M = Integer.parseInt(st.nextToken()); // 초기 파이어볼 수
        K = Integer.parseInt(st.nextToken()); // 이동 명령 횟수

        // 초기 파이어볼 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // 0-indexed
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        // K번 이동 및 처리 반복
        for (int i = 0; i < K; i++) {
            move();  // 모든 파이어볼 이동
            merge(); // 같은 위치의 파이어볼 처리
        }

        // 남은 파이어볼 질량의 총합 계산
        int answer = 0;
        for (Fireball f : fireballs) {
            answer += f.m;
        }
        System.out.println(answer);
    }

    // 파이어볼 이동 메서드
    static void move() {
        map = new ArrayList[N][N]; // 새 맵 초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();

        // 파이어볼마다 이동 계산
        for (Fireball f : fireballs) {
            int nr = (f.r + dr[f.d] * f.s % N + N) % N; // 모듈러 연산으로 격자 밖 방지
            int nc = (f.c + dc[f.d] * f.s % N + N) % N;
            map[nr][nc].add(new Fireball(nr, nc, f.m, f.s, f.d));
        }

        fireballs.clear(); // 기존 리스트 초기화 (병합 후 다시 채울 것)
    }

    // 같은 위치에 있는 파이어볼 처리 (병합, 분할)
    static void merge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<Fireball> cell = map[i][j];
                if (cell.size() == 0) continue;

                // 파이어볼이 한 개일 경우 병합 없이 그대로 저장
                if (cell.size() == 1) {
                    fireballs.add(cell.get(0));
                } else {
                    // 질량과 속력의 총합 계산
                    int sumM = 0, sumS = 0;
                    boolean allEven = true, allOdd = true;

                    for (Fireball f : cell) {
                        sumM += f.m;
                        sumS += f.s;
                        if (f.d % 2 == 0) allOdd = false;
                        else allEven = false;
                    }

                    // 새로운 파이어볼 생성 조건
                    int newM = sumM / 5; // 질량 조건
                    if (newM == 0) continue; // 질량 0이면 생성 X

                    int newS = sumS / cell.size(); // 평균 속력

                    // 방향 설정 (전부 짝수 또는 전부 홀수인지 확인)
                    int[] newDirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                    for (int d : newDirs) {
                        fireballs.add(new Fireball(i, j, newM, newS, d));
                    }
                }
            }
        }
    }
}