class Solution {
    public int[] solution(int brown, int yellow) {
        int s = brown + yellow;
        
        for (int h = 1; h <= s / 2; h++) {
            if (s % h == 0) {
                int w = s / h;
                if (w >= h && (w - 2) * (h - 2) == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        return new int[]{0, 0};
    }
}