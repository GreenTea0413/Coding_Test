class Solution {
    int[] w;
    int[] d;
    int len;
    int answer = Integer.MAX_VALUE;
    int[] wall;
    public int solution(int n, int[] weak, int[] dist) {
        w = weak; d = dist; len = n;
        wall = new int[len * 2];
        for(int i = 0; i < weak.length; i++){
            wall[weak[i]] = weak[i];
            wall[weak[i] + len] = weak[i] + len;
        }
        
        dfs(new boolean[dist.length], 0, new int[dist.length]);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void dfs(boolean[] v, int depth, int[] arr){
        if(depth == arr.length){
            for(int i = 0; i < len; i++){
                int count = check(arr, i);
                if(count != -1) {
                    answer = Math.min(answer, count);
                }
            }
            return;
        }
        
        for(int i = 0; i < v.length; i++){
            if(!v[i]){
                v[i] = true;
                arr[depth] = d[i];
                
                dfs(v, depth + 1, arr);
                
                v[i] = false;
                arr[depth] = 0;
            }
        }
    }
    
    int check(int[] arr, int start){
        // 이제 조합 짠걸로 weak2배로 만든 다음에 범위 안에서 돌게끔하기
        // 한번이라도 되면 true로 내보내기
        // arr 첫 조합을 4,3,2,1이 되었다고 생각하고
        int f = 0;
        int cur = wall[start] + arr[f];
        for(int i = start; i < start + len; i++){
            if(wall[i] > cur){
                f++;
                if(f == arr.length) return -1;
                cur = wall[i] + arr[f];
            }
        }
        return f + 1;
    }
}