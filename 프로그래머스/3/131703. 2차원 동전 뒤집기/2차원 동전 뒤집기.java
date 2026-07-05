class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;

        // diff 배열 생성
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 이걸로 뒤집어야하는 부분들을 찾아서 diff에 설정 diff가 1이면 다르다는 뜻이니까 그걸 뒤집어야함
                diff[i][j] = beginning[i][j] ^ target[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;

        // R[0] = 0 또는 1
        for (int firstRow = 0; firstRow <= 1; firstRow++) {
            int[] row = new int[n];
            int[] col = new int[m];
        
            row[0] = firstRow;

            // diff[0][j] = row[0] ^ col[j]이여서 반대로 ^ row[0]를 옮겨서
            // col에 대해서 뒤집어야하는지 안뒤집어도 되는지 값 넣기
            for (int j = 0; j < m; j++) {
                col[j] = diff[0][j] ^ row[0];
            }

            // diff[i][0] = row[i] ^ col[0]
            // 동일하게 하기
            for (int i = 1; i < n; i++) {
                row[i] = diff[i][0] ^ col[0];
            }

            boolean possible = true;

            // 모든 칸 검증
            // 했을때 각 row랑 col이 한개만 1일때 뒤집었을 때 값이 달라짐
            // 둘다 1이거나 0이면 그대로 원점이기때문에 안뒤집는걸로 쳐야함
            for (int i = 0; i < n && possible; i++) {
                for (int j = 0; j < m; j++) {
                    if ((row[i] ^ col[j]) != diff[i][j]) {
                        possible = false;
                        break;
                    }
                }
            }

            if (!possible) continue;

            // row, col이 1이면 diff랑 다르기 때문에 뒤집어야한다는 뜻
            int count = 0;
            for (int r : row) {count += r;}
            for (int c : col) {count += c;}

            answer = Math.min(answer, count);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}