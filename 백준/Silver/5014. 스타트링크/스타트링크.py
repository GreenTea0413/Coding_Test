from collections import deque
F,S,G,U,D = map(int, input().split())

# F가 최대 높이
# S가 현재 위치
# G가 목표 위치
# U가 위로 U만큼 이동
# D가 아래로 D만큼 이동

visited = [-1] * (F + 1)
visited[S] = 0
queue = deque([S])


while queue :
    cur = queue.popleft()

    for nxt in [cur+U, cur - D] :
        if 0 < nxt <= F and visited[nxt] == - 1 :
            visited[nxt] = visited[cur] + 1
            queue.append((nxt))

if visited[G] == -1 :
    print('use the stairs')
else :
    print(visited[G])
