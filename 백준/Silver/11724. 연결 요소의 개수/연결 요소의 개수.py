import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = {i: [] for i in range(1, N + 1)}

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = set()
answer = 0

for i in range(1, N + 1):
    if i not in visited:
        answer += 1
        queue = deque([i])
        visited.add(i)

        while queue:
            now = queue.popleft()
            for nxt in graph[now]:
                if nxt not in visited:
                    visited.add(nxt)
                    queue.append(nxt)

print(answer)