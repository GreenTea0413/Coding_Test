import sys
from collections import deque

input = sys.stdin.readline

maps = [0] * 101
n, m = map(int, input().split())
# 사다리와 뱀의 값을 배열에 그대로 넣고 0이 아닐 때 현재 index보다 값이 크면 사다리
# 아니면 뱀
for _ in range(n) :
    a,b = map(int, input().split())
    maps[a] = b
for _ in range(m) :
    c,d = map(int, input().split())
    maps[c] = d

# 횟수, 위치
queue = deque([(0, 1)])
v = [False] * 101
v[1] = True
v[0] = True

while queue :
    count, now = queue.popleft()

    if 100 == now :
        print(count)
        exit()
    
    for i in range(1, 7) :
        next = now + i
        if next <= 100 and v[next] == False :
            if maps[next] == 0 :
                queue.append((count + 1, next))
                v[next] = True
            # 사다리 밟았을 때
            # 8, 52
            elif maps[next] > next :
                queue.append((count + 1, maps[next]))
                v[maps[next]] = True
            elif maps[next] < next :
                queue.append((count + 1, maps[next]))
                v[maps[next]] = True