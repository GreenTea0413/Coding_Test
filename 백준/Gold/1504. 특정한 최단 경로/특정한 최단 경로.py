# 백준 1504 - 특정한 최단 경로
# https://www.acmicpc.net/problem/1504
# 다익스트라 - 경유지 지정
import heapq

N, E = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(E) :
    a,b,c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())

INF = float('inf')

def dijkstra(start) :
    dp = [INF] *(N + 1)
    dp[start] = 0
    hq = []
    heapq.heappush(hq, (0, start))

    while hq :
        cur_dist, now_node = heapq.heappop(hq)

        if dp[now_node] < cur_dist :
            continue

        for next_node, cost  in graph[now_node] :
            next_dist = cost + cur_dist
            if dp[next_node] > next_dist :
                dp[next_node] = next_dist
                heapq.heappush(hq, (next_dist, next_node))
    
    return dp

start_1 = dijkstra(1)
start_v1 = dijkstra(v1)
start_v2 = dijkstra(v2)

path1 = start_1[v1] + start_v1[v2] + start_v2[N]
path2 = start_1[v2] + start_v2[v1] + start_v1[N]

result = min(path1, path2)

if result >= INF:
    print(-1)
else:
    print(result)