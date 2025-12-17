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
        d1 = num // 1000
        d2 = (num // 100) % 10
        d3 = (num // 10) % 10
        d4 = num % 10
        
        next_D = num*2
        if next_D > 9999 :
            next_D = next_D % 10000
        if v[next_D] == False :
            q.append((next_D, st+'D')) # D
            v[next_D] = True
        
        next_S = 9999 if num == 0 else num - 1
        if v[next_S] == False:
            q.append((next_S, st+'S'))
            v[next_S] = True
        
        next_L = d2*1000+d3*100+d4*10+d1
        if v[next_L] == False :
            q.append((next_L, st+'L'))
            v[next_L] = True

        next_R = d4*1000+d1*100+d2*10+d3          
        if v[next_R] == False :
            q.append((next_R, st+'R')) # D     
            v[next_R] = True