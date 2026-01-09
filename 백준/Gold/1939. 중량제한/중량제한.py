import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
max_w = 0

for _ in range(M) :
    a,b,c = map(int,input().split())

    graph[a].append((b,c))
    graph[b].append((a,c))
    max_w = max(max_w, c)

start, end = map(int, input().split())

def bfs(limit) :
    visited = [False] * (N + 1)
    queue = deque([start])
    visited[start] = True

    while queue :
        s = queue.popleft()

        if s == end:
            return True
        
        for next_node, next_w in graph[s] :
            if visited[next_node] == False and next_w >= limit :
                visited[next_node] = True
                queue.append((next_node))

left, right = 1, max_w
answer = 0 
while left <= right :
    mid = (left + right) // 2

    if bfs(mid) :
        answer = mid
        left = mid + 1
    else :
        right = mid - 1

print(answer)