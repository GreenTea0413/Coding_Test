import sys
input = sys.stdin.readline

N, M = map(int, input().split())
v = [False] * (N+1)

def dfs(path) :
    if len(path) == M :
        for p in path :
            print(p, end =" ")
        print()
        return
    
    for j in range(1,N+1) :
        path.append(j)
        dfs(path)
        path.pop()


dfs([])