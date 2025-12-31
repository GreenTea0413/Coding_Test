import sys
input = sys.stdin.readline
n = int(input())
m = int(input())

INF = float('inf')
graph = [[INF]* n for _ in range(n)]

for i in range(0, n):
    graph[i][i] = 0

for _ in range(m) :
    a,b,c = map(int, input().split())
    graph[a-1][b-1] = min(graph[a-1][b-1], c)


for k in range(n) :
    for i in range(n) :
        for j in range(n) :
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for gr in graph :
    for g in gr :
        if g == INF :
            print(0, end=" ")
        else :
            print(g, end=" ")
    print()
