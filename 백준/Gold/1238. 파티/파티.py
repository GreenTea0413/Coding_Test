import heapq
N, M, X = map(int, input().split())
INF = float('inf')
answer = 0
graph = [[] for _ in range(N+1)]

for _ in range(M) :
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    
x_dp = [INF] * (N + 1)
x_dp[X] = 0
x_hq = []
heapq.heappush(x_hq, (0, X))

while x_hq :
    cur_dist, now = heapq.heappop(x_hq)

    if x_dp[now] < cur_dist :
        continue
        
    for next_node, cost in graph[now] :
        next_dist = cur_dist + cost

        if x_dp[next_node] > next_dist :
            x_dp[next_node] = next_dist
            heapq.heappush(x_hq, (next_dist,next_node))

# X로 모든 학생들이 왔다갔다가 가야함
for i in range(1, N + 1) :
    if i == X : 
        continue
    dp = [INF] * (N + 1)
    dp[i] = 0
    hq = []
    heapq.heappush(hq, (0, i))

    while hq :
        cur_dist, now = heapq.heappop(hq)

        if dp[now] < cur_dist :
            continue
            
        for next_node, cost in graph[now] :
            next_dist = cur_dist + cost

            if dp[next_node] > next_dist :
                dp[next_node] = next_dist
                heapq.heappush(hq, (next_dist,next_node))
    answer = max(dp[X] + x_dp[i], answer)

print(answer)