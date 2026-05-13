class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        // 4부터 17까지
        // index 0 부터 생각해서 -1
        for (long i = l; i <= r; i++) {
            if (isOne(i - 1, n)) answer++;
        }
        return answer;
    }

    public boolean isOne(long idx, int n) {
        if (n == 1) return idx != 2; // 5개 중 3번째(index 2)는 0

        long size = (long) Math.pow(5, n - 1);
        int block = (int) (idx / size); // 몇 번째 구간인지

        if (block == 2) return false; // 가운데 구간은 무조건 0

        return isOne(idx % size, n - 1); // 나머지 구간은 재귀
    }
}