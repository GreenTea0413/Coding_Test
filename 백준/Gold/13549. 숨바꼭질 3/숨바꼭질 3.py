# 백준 13549 - 숨바꼭질 3
# https://www.acmicpc.net/problem/13549
# 난이도: 골드 5
# 알고리즘: 0-1 BFS / 다익스트라

import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())

if N >= K :
    print(N-K)
    exit()

v = set([N])
q = deque([(N,0)])

while q :
    x, d = q.popleft()
    if x == K : 
        print(d)
        exit()

    if 0 <= x*2 <= 100000 and x * 2 not in v :
        q.appendleft((x*2, d))
        v.add(x*2)
    
    for i in (-1, 1) :
        nx = x + i
        if 0 <= nx <= 100000 and nx not in v :
            q.append((nx, d +1))
            v.add(nx)

    

