import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
arr = [0] + [int(input()) for _ in range(n)]

visited = [False] * (n + 1)
path = [False] * (n + 1)
result = []

def dfs(start) :
    visited[start] = True
    path[start] = True

    nxt = arr[start]

    if not visited[nxt] :
        dfs(nxt)
    elif path[nxt] :
        cur = nxt
        while True :
            result.append(cur)
            cur = arr[cur]
            if cur == nxt :
                break

    path[start] = False

for i in range(1, n + 1) :
    if not visited[i] :
        dfs(i)

result.sort()
print(len(result))
for r in result :
    print(r)