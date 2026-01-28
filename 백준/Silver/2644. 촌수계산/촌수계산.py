## 부모 자식 1촌
## 할아버지 자식 2촌
## 부모의 형제 자식 3촌
from collections import deque
n = int(input())
start, end = map(int, input().split())
count = int(input())
graph = {i : [] for i in range(n + 1)}

for c in range(count) :
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


queue = deque([(start, 0)])
v = [False] * (n + 1) 
v[start] = True

while queue :
    now, dist = queue.popleft()

    if now == end :
        print(dist)
        exit()
    
    for next in graph[now] :
        if v[next] == False :
            queue.append((next,dist+1))
            v[next]= True

print(-1)