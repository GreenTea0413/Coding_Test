import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
M = int(input())

graph = {i : set() for i in range(1, N + 1)}

for _ in range(M) :
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)

queue = deque([1])
visited = [0] * (N + 1)
answer = 0

while queue : 
    now = queue.popleft()
    visited[now] = 1
    
    for next in graph[now] :
        if visited[next] == 0 :
            queue.append(next)
            visited[next] = 1
            answer += 1
print(answer)