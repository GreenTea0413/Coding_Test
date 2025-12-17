# 백준 9019 - DSLR
# https://www.acmicpc.net/problem/9019
# 난이도: 골드 4
# 알고리즘: BFS (연산 추적)

import sys
from collections import deque
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    A, B = map(int,input().split())
    q = deque([(A, '')])
    v = [False] * 10001
    
    while q :
        num, st = q.popleft()
        if num == B :
            print(st)
            break
        
        d = num*2 % 10000
        if v[d] == False :
            q.append((d, st+'D')) # D
            v[d] = True
        
        s = (num - 1) % 10000
        if v[s] == False:
            q.append((s, st+'S'))
            v[s] = True
        
        l = num // 1000 + (num % 1000) * 10
        if v[l] == False :
            q.append((l, st+'L'))
            v[l] = True

        r = num // 10 + (num % 10) * 1000
        if v[r] == False :
            q.append((r, st+'R')) #R 
            v[r] = True