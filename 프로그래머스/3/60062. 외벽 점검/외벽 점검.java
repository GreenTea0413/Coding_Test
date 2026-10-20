class Solution {
    int[] wall;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        int w = weak.length;
        int d = dist.length;
        wall = new int[w * 2];
        // 1 5 6 10 13 17 18 22
        for(int i = 0; i < w; i++){
            wall[i] = weak[i];
            wall[i + w] = weak[i] + n;
        }
        
        dfs(new boolean[d], 0, new int[d], dist, w);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void dfs(boolean[] v, int depth, int[] arr, int[] dist, int w){
        if(depth == arr.length){
            // weak 길이로 두고 고장난곳까지 사람들이 어디까지 도달할 수 있는가
            for(int i = 0; i < w; i++){
                int count = check(arr, i, w);
                if(count != -1) answer = Math.min(answer, count);
            }
            return;
        }
        
        for(int i = 0 ; i < dist.length; i++){
            if(!v[i]){
                v[i] = true;
                arr[depth] = dist[i];
                
                dfs(v, depth + 1, arr, dist, w);
                
                v[i] =false;
                arr[depth] = 0;
            }
        }
    }
    
    int check(int[] arr, int start, int w){
        int f = 0;
        int cur = arr[f] + wall[start];
        
        for(int i = start; i < start + w; i++){
            if(wall[i] > cur){
                f++;
                if(f == arr.length) return -1;
                cur = arr[f] + wall[i];
            }
        }
        return f  + 1;
    }
}