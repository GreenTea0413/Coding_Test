import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int [][] room;
    // 오른쪽, 아래, 왼쪽, 위 → 인덱스: 0,1,2,3
    static int[] dx = {0, 1, 0, -1}; // 행 이동
    static int[] dy = {1, 0, -1, 0}; // 열 이동

    // 0 이면 오른쪽 1칸
    // 1 이면 밑으로 1칸
    // 2 면 왼쪽으로 1칸
    // 3 이면 위로 1칸

    // 이걸로 이제 상하좌우 조합 가지고 cctv 마다 방향 다르게 다 주는거임!
    static int min = Integer.MAX_VALUE;
    // 문제 부족한거
    // cctv 좌표랑 타입을 주는 객체 만들어보기
    static class CCTV{
        int x, y, type;
        CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    // 겍체를 담는 동적배열
    static List<CCTV> cctvs = new ArrayList<>();
    // 타입에 따라 방향 배열 주기
    static int[][] getDirections(int type){
        switch (type) {
            // 각 방향에 대해서 dx dy가 활용될 수 있게 배정
            case 1: return new int[][]{{0}, {1}, {2}, {3}};
            case 2: return new int[][]{{0, 2}, {1, 3}};
            case 3: return new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}};
            case 4: return new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
            case 5: return new int[][]{{0, 1, 2, 3}};
        }
        return new int[0][];
    }
    // dfs에서 돌아갈 배열을 각각 복사해서 계속 돌아가게끔
    // 예를 들어 cctv 1에 대해서 초기 배열을 각 방향마다 복사해서 돌림
    // 그리고 또 복사한것들에 대해서 다음 cctv가 돌아가게끔 해주는 초기 배열 복사 후 반환
    // clone 처음 써봄
    static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = origin[i].clone();
        }
        return copy;
    }
    // 이거는 도착했을 떄 지도 보고 0인것만 보고 +1 해주기 그거랑 min 비교
    static int countBlind(int[][] map) {
        int count = 0;
        for(int i =0; i < N; i++){
            for (int j = 0; j < M; j++){
                if(map[i][j] == 0) count += 1;
            }
        }
        return count;
    }

    // 그럼 이제 Dfs는 해당 방향에 대해서 이동한 다음 해당 cctv가 어디까지 뻗어가는지
    // 그 후에 그 배열을 다음 dfs에게 넘겨주기
    static void dfs(int depth, int[][] map){
        if (depth == cctvs.size()) {
            min = Math.min(min, countBlind(map));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int type = cctv.type;

        int[][] directions = getDirections(type);

        for (int[] dirs : directions) {
            // 이게 아까 말한 cctv타입 마다 현 배열 복사
            int[][] copied = copyMap(map);
            // 이제 복사한걸로 다음 cctv에 대해서 이동하고 배열 변경
            // 이러면 여러개의 배열이 점차 쌓이고 쌓이면서 마지막 dfs 일때 0으로
            // 되어있는 길이를 구해서 min을 구하는 방식
            for (int dir : dirs) {
                int nx = cctv.x;
                int ny = cctv.y;
        
                while (true) {
                    nx += dx[dir];
                    ny += dy[dir];
        
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || copied[nx][ny] == 6) break;
                    if (copied[nx][ny] == 0) copied[nx][ny] = -1;
                }
            }
            // depth + 1 는 다음 cctv를 나타냄
            dfs(depth + 1, copied);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        // N세로, M가로 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room= new int[N][M];
        // Cctv는 8개가 넘으면 안된다.. ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 에잇! 문제 너무 어렵네요
        for (int i = 0; i < N; i++){
            st = new StringTokenizer( br.readLine());
            for(int j = 0; j < M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= room[i][j] && room[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, room[i][j]));
                }
            }
        }
        // 일단 여기까지 배열
        // 1번 CCTV는 한 쪽 방향만 감시할 수 있다. 2번과 3번은 두 방향을 감시할 수 있는데, 
        // 2번은 감시하는 방향이 서로 반대방향이어야 하고, <- ->
        // 3번은 직각 방향이어야 한다. <- ^
        // 4번은 세 방향
        // 5번은 네 방향
        // 회전은 항상 90도 방향
        // 지도에서 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호
        dfs(0,room);
       
        System.out.println(min);
    }
}
