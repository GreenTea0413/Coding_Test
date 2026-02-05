def dfs(n,m,answer,visited) :
    if(len(answer) == m) :
        print(" ".join(map(str,answer)))
        return
    
    for i in range(1, n + 1) :
        dfs(n,m,answer + [i],visited)
            
n, m = map(int,input().split())
visited = [False for _ in range(n+1)] 
dfs(n,m,[],visited)