import heapq

N = int(input())
M = int(input())
graph = {i : [] for i in range(N + 1)}

for _ in range(M) :
    a, b, c = map(int, input().split())
    graph[a].append((b,c))

S, E = map(int, input().split())

INF = float('inf')
dp = [INF] * (N+1)
dp[S] = 0
pq = [(0, S)]

while pq:
    cur_dist, x = heapq.heappop(pq)

    if cur_dist > dp[x]:
        continue

    if x == E:
        break

    for nxt, dist in graph[x]:
        new_dist = cur_dist + dist
        if dp[nxt] > new_dist:
            dp[nxt] = new_dist
            heapq.heappush(pq, (new_dist, nxt))

print(dp[E])