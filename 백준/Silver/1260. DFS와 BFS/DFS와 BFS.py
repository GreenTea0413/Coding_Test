import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = {i : [] for i in range(1, N + 1)}

for _ in range(M) :
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(1, N + 1) :
    graph[i] = sorted(graph[i])


visited = [0] * (N + 1)
visited[V] = 1 
path = [V]
def dfs(start) :
    visited[start] = 1
    for next in graph[start] :
        if visited[next] != 1 :
            visited[next] = 1
            path.append(next)
            dfs(next)


dfs(V)
print(' '.join(map(str, path)))

queue = deque([V])
visited = [0] * (N + 1)
visited[V] = 1
path = [V]
while queue :
    now = queue.popleft()

    for next in graph[now] :
        if(visited[next] != 1) :
            visited[next] = 1
            queue.append(next)
            path.append(next)

print(' '.join(map(str,path)))