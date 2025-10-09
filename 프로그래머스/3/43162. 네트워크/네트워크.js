function solution(n, computers) {
    var answer = 0;
    const visited = Array.from({length : n}, () => false)
    // visited[i] 가 false면 bfs 시작
    // 1일 때 2, 3 방문하는지 비교
    // 갔는데 2->1 가르키면 true
    
    function bfs(num){
        visited[num] = true
        
        for(let i = 0; i < n; i++){
            if(!visited[i] && computers[num][i] === 1){
                bfs(i)
            }
        }
    }
    
    for(let i = 0; i < n; i++){
        if(!visited[i]){
            bfs(i)
            answer++;
        }
    }
    
    return answer;
}