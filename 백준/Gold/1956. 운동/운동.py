import sys
input = sys.stdin.readline

INF = float('inf')
V, E = map(int, input().split())

dist = [[INF] * V for _ in range(V)]

for _ in range(E):
    a, b, c = map(int, input().split())
    dist[a-1][b-1] = min(dist[a-1][b-1], c)

for k in range(V):
    for i in range(V):
        if dist[i][k] == INF:
            continue
        for j in range(V):
            if dist[k][j] == INF:
                continue
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

answer = INF
for v in range(V):
    answer = min(answer, dist[v][v])

print(-1 if answer == INF else answer)