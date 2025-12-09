import sys
input = sys.stdin.readline

N = int(input())
graph = {i : set() for i in range(1, N + 1)}
visited = [0] * (N+1)
for _ in range(N - 1) :
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)

stack =[1]

while stack :
    start = stack.pop()
    for num in graph[start] :
        if visited[num] == 0 :
            visited[num] = start
            stack.append(num)



for x in range(2, N+1) :
    print(visited[x])