class Solution {
    public int[] solution(int n, int s) {
        // n = 2고 s = 9면 { 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 }
        // 집합을 만들었으면 그 내부에 요소들을 모두 제곱해서 더했을 때 최대값으 구해라..
        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        
        // 개수 다 구하면 터질거 같은데..
        // 10000개까지 만들라고 하면 집합이 좀 많으니까
        // 일단 규칙을 보면 가장 가운데에서 가까울 수록 높은거 같음
        // 9 / 2 -> 4, 1. -> answer = [4, 4]
        int div = s / n;
        int remain = s % n;
        for(int i = 0; i < n; i++){
            answer[i]  = div;
        }
        
        // 그 다음 남은거 만큼 더해주기 만약에 11 5 -> 2 2 2 2 3 뒤에서부터 하나씩 + 해주면 되겠네
        for(int i = n - 1; i >= n - remain; i--){
            answer[i] += 1;
        }
        
        return answer;
    }
}