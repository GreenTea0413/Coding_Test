import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
graph = {i : [] for i in range(n + 1)}

for _ in range(n-1) :
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

arr = [0] * (n + 1)

def dfs(start) :
    for node in graph[start] :
        if arr[node] == 0 :
            arr[node] = start
            dfs(node)
arr[1] = -1
dfs(1)

for i in range(2,n + 1) :
    print(arr[i])