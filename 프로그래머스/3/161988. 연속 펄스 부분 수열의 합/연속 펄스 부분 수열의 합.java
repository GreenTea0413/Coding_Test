class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;

        long max1 = 0;
        long max2 = 0;

        for (int i = 0; i < sequence.length; i++) {

            long val1 = sequence[i] * (i % 2 == 0 ? 1 : -1);
            long val2 = sequence[i] * (i % 2 == 0 ? -1 : 1);

            max1 = Math.max(val1, max1 + val1);
            max2 = Math.max(val2, max2 + val2);

            answer = Math.max(answer, Math.max(max1, max2));
        }
        return answer;
    }
}