from collections import deque
import sys
input = sys.stdin.readline

N, K = map(int, input().split())

q = deque([(N,0)])
v = set()
v.add(N)

while q :
    x, d = q.popleft()

    if x==K :
        print(d)
        exit()

    for i in (x-1, x+1, x*2) :
        if 0<= i <= 100000 and i not in v:
            q.append((i, d+1))
            v.add(i)

